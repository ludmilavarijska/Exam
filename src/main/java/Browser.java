import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\$\\QA Complete 2021\\Selenium WebDriver\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg");
    }

    public static void quit() {
        driver.quit();
    }



}
