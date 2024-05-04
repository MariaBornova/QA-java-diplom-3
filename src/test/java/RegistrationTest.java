import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.RegistrationPage;
import java.time.Duration;
import static data.Url.LOGIN_PAGE_URL;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Успешная регистрация пользователя. Пароль 6 символов")
    public void successRegistrationWithAllCorrectData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .enterUserDataForRegistration(user)
                .clickRegistrationButton();
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Регистрация пользователя с паролем в 5 символов")
    public void registrationWithPasswordFiveSymbolsMistakeMessage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setPassword("qwrt");
        registrationPage.openRegistrationPage()
                .enterUserDataForRegistration(user)
                .clickRegistrationButton();
        Assert.assertTrue("Некорректный пароль", registrationPage.passwordError());
    }
}
