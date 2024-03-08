package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By registerButton = By.className("Auth_link__1fOlj");
    private By emailFild = By.xpath(".//form/fieldset[1]/div/div/input");
    private By passwordFild = By.xpath(".//form/fieldset[2]/div/div/input");
    private By loginButton = By.xpath(".//*[text() = 'Войти']");
    private By forgotPasswordButton = By.xpath(".//*[text() = 'Восстановить пароль']");
    public void setEmail(String email) {
        driver.findElement(emailFild).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordFild).sendKeys(password);
    }

    public void login1(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void clickForgotPasswordButton(){
        driver.findElement(forgotPasswordButton).click();
    }


    public boolean checkLoginButton() {
        return driver.findElements(loginButton).size() > 0;
    }

}
