package WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private WebDriver webDriver;
    private String browserName;

    public WebDriverFactory() {
        this.browserName = System.getProperty("browser");
    }
    public WebDriver getWebDriver() {
        if (browserName == null) {
            browserName = "chrome";
        }
        ChromeOptions options = new ChromeOptions();
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                webDriver.manage().window().maximize();
                break;

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                return new ChromeDriver(options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex"));
        }
        return webDriver;
    }
}
