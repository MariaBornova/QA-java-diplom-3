import apiMethods.UserApi;
import static data.Url.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.UserProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ProfilePageTest extends BaseTest{
    @Test
    @DisplayName("Проверка перехода в личный кабинет для неавторизированного пользователя")
    public void clickOnProfileByNotAuthUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLoginAccountButton();
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка перехода на главную страницу при клике на лого")
    public void clickOnLogo() {
        UserApi.create(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginAccountButton();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.clickLogo();
        assertEquals(BASE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка перехода на главную страницу при клике по конструктору")
    public void checkClickConstructorButton() {
        UserApi.create(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.clickConstructorButton();
        assertEquals(BASE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void checkClickExitButton() {
        UserApi.create(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginAccountButton();
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.clickExitButton();
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());

    }
}
