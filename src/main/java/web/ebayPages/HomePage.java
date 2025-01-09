package web.ebayPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;
import web.manager.WebDriverManager;

public class HomePage {

    public static String searchResult;
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBoxText;

    @FindBy(xpath="//ul[@class='srp-results srp-list clearfix']/li[1]/descendant::div[@class='s-item__info clearfix']/a/div/span")
    private WebElement firstResultLink;

    @FindBy(xpath="//input[@value='Search']")
    private WebElement searchButton;

    public void searchQuery(String query){
        WebDriverUtils.waitUntilClickable(WebDriverManager.getChromeDriver(),searchBoxText);
        searchBoxText.sendKeys(query);
        WebDriverUtils.waitUntilClickable(WebDriverManager.getChromeDriver(),searchButton);
        searchButton.click();
    }

    public void clickFirstElementFromResult(){
        WebDriverUtils.waitUntilClickable(WebDriverManager.getChromeDriver(),firstResultLink);
        searchResult=firstResultLink.getText();
        firstResultLink.click();
    }
}
