import ForUser.APIcommand;
import ForUser.Create;
import ForUser.Login;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import WebDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginUserTest {
    public static String token;
    private WebDriver webDriver;
    private WebDriverFactory browser = new WebDriverFactory();
    @Before
    public void startUp() {
        webDriver = browser.getWebDriver();
        Create create = new Create("starknetl@yandex.ru", "100500", "Jack");
        APIcommand.createUser(create);
        Login login = new Login("starknetl@yandex.ru", "100500");
        token = APIcommand.getToken(login);
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку войти")
    public void loginUserEnterButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickEnterButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
       objLoginPage.login1("starknetl@yandex.ru", "100500");
        assertTrue(objMainPage.checkCreateOrderButton());
    }
    @Test
    @DisplayName("Проверка авторизации через личный кабинет")
    public void loginUserPersonalButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickPersonalAccauntButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.login1("starknetl@yandex.ru", "100500");
        assertTrue(objMainPage.checkCreateOrderButton());
    }
    @Test
    @DisplayName("Проверка авторизации через переход со страницы регистрации")
    public void loginUserFromRegisterPage(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickEnterButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(webDriver);
        objRegisterPage.clickLoginButton();
        objLoginPage.login1("starknetl@yandex.ru", "100500");
        assertTrue(objMainPage.checkCreateOrderButton());
    }

@Test
@DisplayName("Проверка авторизации через переход со страницы востановления пороля")
public void loginUserFromForgotPasswordPage(){
    webDriver.get("https://stellarburgers.nomoreparties.site/");
    MainPage objMainPage = new MainPage(webDriver);
    objMainPage.clickEnterButton();
    LoginPage objLoginPage = new LoginPage(webDriver);
    objLoginPage.clickForgotPasswordButton();
    objLoginPage.clickLoginButton();
    objLoginPage.login1("starknetl@yandex.ru", "100500");
    assertTrue(objMainPage.checkCreateOrderButton());
    webDriver.quit();
}

    @After
    public void clean(){
        webDriver.quit();
        APIcommand.deleteUser(token);
    }
}
