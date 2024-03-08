package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameFild = By.xpath(".//form/fieldset[1]/div/div/input");
    private By emailFild = By.xpath(".//form/fieldset[2]/div/div/input");
    private By passwordFild = By.xpath(".//form/fieldset[3]/div/div/input");
    private By registracionButton = By.xpath(".//*[text() = 'Зарегистрироваться']");
    private By wrongPassword = By.xpath(".//*[text()='Некорректный пароль']");
    private By loginButton = By.className("Auth_link__1fOlj");

    public void setName(String name) {
        driver.findElement(nameFild).sendKeys(name);
    }
    public void setEmail(String email) {
        driver.findElement(emailFild).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordFild).sendKeys(password);
    }
    public void clickRegisracionButton(){
        driver.findElement(registracionButton).click();
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

public void registraition(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisracionButton();
}
    public boolean checkError() {
        return driver.findElements(wrongPassword).size() > 0;
    }
}
