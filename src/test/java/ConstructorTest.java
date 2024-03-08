import Pages.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import WebDriver.WebDriverFactory;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    private WebDriver webDriver;
    private WebDriverFactory browser = new WebDriverFactory();

    @Before
    public void startUp() {
        webDriver = browser.getWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода в раздел булки")
    public void bunButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
objMainPage.clickFillingButton();
objMainPage.clickBunButton();
String actual = objMainPage.activeTab();
String expected = "Булки";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка перехода в раздел соусы")
    public void souseButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickSoucesButton();
        String actual = objMainPage.activeTab();
        String expected = "Соусы";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка перехода в раздел начинки")
    public void fillingButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickFillingButton();
        String actual = objMainPage.activeTab();
        String expected = "Начинки";
        assertEquals(expected, actual);
    }

    @After
    public void finish(){
        webDriver.quit();
    }

}
