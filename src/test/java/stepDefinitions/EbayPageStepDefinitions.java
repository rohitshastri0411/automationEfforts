package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import web.ebayPages.HomePage;
import web.ebayPages.ListingPage;
import web.manager.ScenarioManager;
import web.manager.WebDriverManager;

public class EbayPageStepDefinitions {

    HomePage homePage = new HomePage(WebDriverManager.getChromeDriver());
    ListingPage listingPage = new ListingPage(WebDriverManager.getChromeDriver());


    @Given("Navigate to ebay website")
    public void navigateToEbayWebsite() {
        WebDriverManager.getChromeDriver().get("https://www.ebay.com/");
    }

    @When("Search {string}")
    public void search(String searchQuery) {
        homePage.searchQuery(searchQuery);
    }

    @When("Click on first book in the list")
    public void clickOnFirstBookInTheList() {
        homePage.clickFirstElementFromResult();
    }

    @When("Click on add to cart from item listing page")
    public void clickOnAddToCartFromItemListingPage() throws InterruptedException {
        listingPage.clickAddToCart();
    }

    @Then("Verify cart is has been updated and displays number of items")
    public void verifyCartIsHasBeenUpdatedAndDisplaysNumberOfItems() throws InterruptedException {
        Assert.assertTrue(listingPage.isCartUpdated());
        listingPage.clickCart();
        ScenarioManager.getInstance().getScenario().log("<pre><b>Item from Cart : </b>\n"+listingPage.getLinkTextFromCart()+"</pre>");
        ScenarioManager.getInstance().getScenario().log("<pre><b>Item from Search Page : </b>\n"+HomePage.searchResult+"</pre>");
        Assert.assertEquals(listingPage.getLinkTextFromCart(),HomePage.searchResult);
    }

    @And("closeBrowser")
    public void closeBrowser() {
        WebDriverManager.closeChrome();
    }
}
