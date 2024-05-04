import data.BrowserProperties;
import apiMethods.UserApi;
import apiMethods.UserData;
import apiMethods.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    User user;
    String accessToken;

    WebDriver driver;
    @Before
    @Step("Запускаем браузер и генерируем данные для регистрации пользователя")
    public void setUp() {
        driver = BrowserProperties.getDriver();
        user = UserData.getNewRandomUser();
    }
    @After
    @Step("Удаляем профиль пользователя и закрываем браузер")
    public void tearDown() {
        Response responseLoginUser = UserApi.login(user);
        try {
            accessToken = responseLoginUser.then().log().all().extract().path("accessToken").toString();
        }
        catch (Exception e) {
            accessToken = null;
        }
        if (accessToken != null) {
            UserApi.delete(accessToken);
        }
        driver.quit();
    }
}
