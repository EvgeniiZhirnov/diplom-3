package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enterButton = By.xpath(".//*[text() = 'Войти в аккаунт']");
    private By createOrderButton = By.xpath(".//*[text() = 'Оформить заказ']");
    private By personalAccauntButton = By.xpath(".//*[text() = 'Личный Кабинет']");
    private By bunButton = By.xpath(".//span[text() = 'Булки']");
    private By soucesButton = By.xpath(".//span[text() = 'Соусы']");
    private By fillingButton = By.xpath(".//span[text() = 'Начинки']");
    private By selectionTab = By.className("tab_tab_type_current__2BEPc");

    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
    public boolean checkCreateOrderButton() {
        return driver.findElements(createOrderButton).size() > 0;
    }
public void clickPersonalAccauntButton(){ driver.findElement(personalAccauntButton).click();}
    public void clickBunButton(){
        driver.findElement(bunButton).click();}
    public void clickSoucesButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(soucesButton));
        driver.findElement(soucesButton).click();}
    public void clickFillingButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();}
    public String activeTab(){return driver.findElement(selectionTab).getText();}


}
