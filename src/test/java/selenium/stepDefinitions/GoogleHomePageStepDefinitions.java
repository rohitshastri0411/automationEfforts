package selenium.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.pages.GoogleHomePage;
import selenium.webDriverUtil.DriverManager;

public class GoogleHomePageStepDefinitions {

    WebDriver driver;
    @Given("I open browser")
    public void openBrowser(){
      DriverManager.getDriver().get("https://www.google.com/");
    }

    @Then("Google homepage should get display")
    public void googleHomepageShouldGetDisplay() {
        GoogleHomePage googleHomePage = new GoogleHomePage(DriverManager.getDriver());
        Assert.assertTrue( googleHomePage.isSerchBoxDisplayed());
    }
}
