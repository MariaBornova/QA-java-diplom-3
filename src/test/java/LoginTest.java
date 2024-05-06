import apimethods.UserApi;
import static data.Url.BASE_URL;
import pageobject.LoginPage;
import pageobject.RecoveryPasswordPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageByEnterAccount() {
        UserApi.create(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertTrue(mainPage.isAuthorized());

    }
    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginFromMainPageProfileButton() {
        UserApi.create(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLoginAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertTrue(mainPage.isAuthorized());
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationPage() {
        UserApi.create(user);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertTrue(mainPage.isAuthorized());
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromRecoveryPasswordPage() {
        UserApi.create(user);
        RecoveryPasswordPage forgotPasswordPage = new RecoveryPasswordPage(driver);
        forgotPasswordPage.openRecoveryPasswordPage().clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertTrue(mainPage.isAuthorized());
    }

}