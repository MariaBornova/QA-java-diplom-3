package pageobject;

import apiMethods.User;
import static data.Url.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {
    private static final By NAME_FOR_REGISTRATION = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By EMAIL_FOR_REGISTRATION = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By PASSWORD_FOR_REGISTRATION = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    public static By WRONG_PASSWORD_MESSAGE = By.xpath(".//p[text()='Некорректный пароль']");
    private static final By ENTER_BUTTON = By.xpath(".//*[text()='Войти']");

    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }
    @Step("Открытие страницы Регистрация")
    public RegistrationPage openRegistrationPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }
    @Step("Ввод имени, e-mail, пароль")
    public RegistrationPage enterUserDataForRegistration(User user) {
        enterRegisterName(user.getName());
        enterRegisterEmail(user.getEmail());
        enterRegisterPassword(user.getPassword());
        return this;
    }

    // не используются
    @Step("Ввод имени")
    public void enterRegisterName(String name) {
        driver.findElement(NAME_FOR_REGISTRATION).click();
        driver.findElement(NAME_FOR_REGISTRATION).sendKeys(name);
    }

    @Step("Ввод e-mail")
    public void enterRegisterEmail(String email) {
        driver.findElement(EMAIL_FOR_REGISTRATION).click();
        driver.findElement(EMAIL_FOR_REGISTRATION).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterRegisterPassword(String password) {
        driver.findElement(PASSWORD_FOR_REGISTRATION).click();
        driver.findElement(PASSWORD_FOR_REGISTRATION).sendKeys(password);
    }

    @Step("Текст «Некорректный пароль»")
    public boolean passwordError() {
        return driver.findElement(WRONG_PASSWORD_MESSAGE).isDisplayed();
    }
    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
}
