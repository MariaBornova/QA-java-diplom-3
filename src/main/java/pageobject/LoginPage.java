package pageobject;

import static data.Url.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private static final By LOGIN_ENTER_BUTTON = By.xpath(".//*[text()='Войти']");
    private static final By LOGIN_EMAIL = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By LOGIN_PASSWORD = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие страницы Входа")
    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }
    @Step("Заполнение - e-mail  и пароля для авторизации пользователя")
    public void authorization(String email, String password) {
        driver.findElement(LOGIN_EMAIL).click();
        driver.findElement(LOGIN_EMAIL).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD).click();
        driver.findElement(LOGIN_PASSWORD).sendKeys(password);
    }
    @Step("Клик по кнопке  Войти ")
    public void clickEnterButton() {
        driver.findElement(LOGIN_ENTER_BUTTON).click();
    }


}
