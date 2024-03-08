import ForUser.APIcommand;
import ForUser.Create;
import ForUser.Login;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import WebDriver.WebDriverFactory;
import static org.junit.Assert.assertTrue;

public class ProfileTest {
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
    @DisplayName("Проверка входа в личный кабинет")
    public void loginUserPersonalButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickPersonalAccauntButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.login1("starknetl@yandex.ru", "100500");
        objMainPage.clickPersonalAccauntButton();
        ProfilePage objProfilePage = new ProfilePage(webDriver);
        assertTrue(objProfilePage.checkExiteButton());
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void exitTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickPersonalAccauntButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.login1("starknetl@yandex.ru", "100500");
        objMainPage.clickPersonalAccauntButton();
        ProfilePage objProfilePage = new ProfilePage(webDriver);
        objProfilePage.clickExiteButton();
        assertTrue(objLoginPage.checkLoginButton());
    }
    @Test
    @DisplayName("Проверка перехода на кнопке конструктор")
    public void construcktorButtonTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(webDriver);
        objMainPage.clickPersonalAccauntButton();
        LoginPage objLoginPage = new LoginPage(webDriver);
        objLoginPage.login1("starknetl@yandex.ru", "100500");
        objMainPage.clickPersonalAccauntButton();
        ProfilePage objProfilePage = new ProfilePage(webDriver);
        objProfilePage.clickConstructorButton();
        assertTrue(objMainPage.checkCreateOrderButton());
    }
@Test
@DisplayName("Проверка перехода по клику на лого")
public void logoClickTest(){
    webDriver.get("https://stellarburgers.nomoreparties.site/");
    MainPage objMainPage = new MainPage(webDriver);
    objMainPage.clickPersonalAccauntButton();
    LoginPage objLoginPage = new LoginPage(webDriver);
    objLoginPage.login1("starknetl@yandex.ru", "100500");
    objMainPage.clickPersonalAccauntButton();
    ProfilePage objProfilePage = new ProfilePage(webDriver);
    objProfilePage.clickLogo();
    assertTrue(objMainPage.checkCreateOrderButton());
}
    @After
    public void clean(){
        webDriver.quit();
        APIcommand.deleteUser(token);
    }
}
