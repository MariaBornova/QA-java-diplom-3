import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;
import static org.junit.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @Test
    @DisplayName("Переход по клику к разделу булки")
    public void menuBunsIsOpenedByClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickButtonSauce();
        mainPage.clickButtonBun();
        assertEquals("Выбрано некорректное меню", "Булки", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Переход по клику к разделу соусы")
    public void menuSauceIsOpenedByClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickButtonSauce();
        assertEquals("Выбрано некорректное меню","Соусы", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Переход по клику к разделу Начинки")
    public void menuFillingsIsOpenedByClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickButtonFillings();
        assertEquals("Выбрано некорректное меню","Начинки", mainPage.getTextFromSelectedMenu());
    }
}
