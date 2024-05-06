package pageobject;

import static data.Url.*;
import io.qameta.allure.Step;
import org.openqa.selenium.*;


public class MainPage {
    private static final By ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By ENTER_ACCOUNT_BUTTON_MAIN = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By ORDER_BUTTON = By.xpath(".//div[starts-with(@class,'BurgerConstructor_basket__container__2fUl3 mt-10')]/button");
    private static final By BUN_MENU_BUTTON = By.xpath(".//span[text()='Булки']");
    private static final By FILLINGS_MENU_BUTTON = By.xpath(".//span[text()='Начинки']");
    private static final By SAUCE_MENU_BUTTON = By.xpath(".//span[text()='Соусы']");
    private static final By CURRENT_MENU = By.cssSelector("div.tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10");



    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие главной страницы")
    public void openMainPage() {
        driver.get(BASE_URL);
    }



    @Step("Клик по кнопке Личный кабинет")
    public void clickLoginAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    @Step("Клик по кнопке логина")
    public void clickAccountButton() {
        driver.findElement(ENTER_ACCOUNT_BUTTON_MAIN).click();
    }

    @Step("Клик по кнопке Булки")
    public void clickButtonBun() {
        driver.findElement(BUN_MENU_BUTTON).click();
    }

    @Step("Клик по кнопке Соусы")
    public void clickButtonSauce() {
        driver.findElement(SAUCE_MENU_BUTTON).click();
    }

    @Step("Клик по кнопке Начинки")
    public void clickButtonFillings() {
        driver.findElement(FILLINGS_MENU_BUTTON).click();
    }

    @Step("Проверить текст текущего меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(CURRENT_MENU).getText();
    }

    @Step("Проверить выполнена ли авторизация")
    public boolean isAuthorized() {
        return driver.findElement(ORDER_BUTTON).isDisplayed();
    }

}
