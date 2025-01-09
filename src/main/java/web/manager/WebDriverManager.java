package web.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    public static WebDriver driver;

    public  static WebDriver getChromeDriver(){
        if(driver==null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().window().fullscreen();
        }
        return driver;
    }

    public  static void closeChrome(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
