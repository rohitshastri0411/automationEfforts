package web.ebayPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;
import web.manager.WebDriverManager;

public class ListingPage {

    public WebDriver driver;

    public ListingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[@id='atcBtn_btn_1']")
    private WebElement addToCartButton;

    @FindBy(xpath="//*[@id='gh-cart-n']")
    private WebElement addedCartMarkLink;

    @FindBy(xpath="//div[@class='cart-bucket-lineitem']/descendant::h3/a")
    private WebElement addedItemLink;

    public void clickAddToCart() throws InterruptedException {
        WebDriverUtils.navigateToNewTab(WebDriverManager.getChromeDriver());
        WebDriverUtils.scrollDown(WebDriverManager.getChromeDriver());
        WebDriverUtils.waitUntilClickable(WebDriverManager.getChromeDriver(),addToCartButton);
        addToCartButton.click();
    }

    public boolean isCartUpdated() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverUtils.waitUntilDisplayed(WebDriverManager.getChromeDriver(),addedCartMarkLink);
        return addedCartMarkLink.isDisplayed();
    }

    public void clickCart(){
        WebDriverUtils.waitUntilClickable(WebDriverManager.getChromeDriver(),addedCartMarkLink);
        addedCartMarkLink.click();
    }

    public String getLinkTextFromCart(){
        WebDriverUtils.waitUntilDisplayed(WebDriverManager.getChromeDriver(),addedItemLink);
        return addedItemLink.getText();
    }
}
