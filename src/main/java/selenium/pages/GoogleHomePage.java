package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.webDriverUtil.DriverManager;

public class GoogleHomePage {
    WebDriver driver;

    public GoogleHomePage(WebDriver driver){
        driver= DriverManager.getDriver();
        PageFactory.initElements( driver, this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBox;

    public boolean isSerchBoxDisplayed(){
        return searchBox.isDisplayed();
    }
}
