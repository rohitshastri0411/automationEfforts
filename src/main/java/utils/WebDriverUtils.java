package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class WebDriverUtils {

    public static void waitUntilClickable(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilDisplayed(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void scrollDown(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
    }

    public static void navigateToNewTab (WebDriver driver) throws InterruptedException {
        String mainWindowHandler = driver.getWindowHandle();
        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        for (String subWindowHandler : handles) {
            if (!mainWindowHandler.equalsIgnoreCase(subWindowHandler)) {
                driver.switchTo().window(subWindowHandler);
            }
        }
    }
}
