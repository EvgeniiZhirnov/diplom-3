package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class ProfilePage {
    private WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By exiteButton = By.xpath(".//*[text() = 'Выход']");
    private By constructorButton = By.xpath(".//*[text() = 'Конструктор']");
    private By logo = By.className("AppHeader_header__logo__2D0X2");

    public boolean checkExiteButton() {
        return driver.findElements(exiteButton).size() > 0;
    }
    public void clickExiteButton(){
        driver.findElement(exiteButton).click();
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickLogo(){
        driver.findElement(logo).click();
    }
}
