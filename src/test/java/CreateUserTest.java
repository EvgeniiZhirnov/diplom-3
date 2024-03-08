import ForUser.APIcommand;
import ForUser.Login;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import WebDriver.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;

public class CreateUserTest {
    public static String token;
    private WebDriver webDriver;
    private WebDriverFactory browser = new WebDriverFactory();
    @Before
    public void startUp() {
        webDriver = browser.getWebDriver();
    }

    @Test
    @DisplayName("Проверка создания аккаунта")
    public void createUserTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickEnterButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(webDriver);
        objRegisterPage.registraition("Jack", "starknetl@yandex.ru", "100500");
        Login login = new Login("starknetl@yandex.ru", "100500");
        token = APIcommand.getToken(login);
assertTrue(objLoginPage.checkLoginButton());
    }

    @Test
    @DisplayName("Проверка появления ошибки при некорректном пароле")
    public void createUserWrongPassword(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickEnterButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(webDriver);
        objRegisterPage.registraition("Jack", "starknetl@yandex.ru", "123");
        assertTrue(objRegisterPage.checkError());
    }
    @After
    public void clean(){
        webDriver.quit();
        if (token != null) {
            APIcommand.deleteUser(token);
        }
    }

}
