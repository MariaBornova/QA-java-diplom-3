package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.Url.*;

public class RecoveryPasswordPage {
    private final WebDriver driver;
    public RecoveryPasswordPage(WebDriver driver) {

        this.driver = driver;
    }
    private static final By LOGIN_ENTER_BUTTON = By.xpath(".//*[text()='Войти']");

    @Step("Переход на страницу восстановления пароля")
    public RecoveryPasswordPage openRecoveryPasswordPage() {
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        return this;
    }
    @Step("Клик по кнопке Войти на странице Восстановления пароля")
    public void clickEnterButton() {
        driver.findElement(LOGIN_ENTER_BUTTON).click();
    }
}
