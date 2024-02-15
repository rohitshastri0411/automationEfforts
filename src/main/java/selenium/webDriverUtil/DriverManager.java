package selenium.webDriverUtil;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver ==null) {
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
            return driver;
    }

    public static void closeDriver(){
        if(driver!= null){
            driver.quit();
            driver=null;
        }
    }
}
