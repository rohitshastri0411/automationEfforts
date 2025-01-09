package stepDefinitions;


import api.RestApiUtil;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import web.manager.ScenarioManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;
import java.util.Map;


public class CoinDeskAPIStepDefinitions {

    private String apiEndpoint;
    private String apiResponse;


    @Given("the API endpoint is {string}")
    public void theApiEndpointIs(String endpoint) {
        apiEndpoint = endpoint;
        ScenarioManager.getInstance().getScenario().log("<pre><b>EndPoint Used : </b>\n"+apiEndpoint+"</pre>");
    }

    @When("a GET request is sent to the endpoint")
    public void aGETRequestIsSentToTheEndpoint() {
        apiResponse = RestApiUtil.getApiResponse(apiEndpoint);
        ScenarioManager.getInstance().getScenario().log("<pre>API Response Used : \n"+apiResponse+"</pre>");
    }

    @Then("the response status code should be {string}")
    public void theResponseStatusCodeShouldBe(String expectedStatusCode) {
        int actualStatusCode = RestApiUtil.getStatusCode(apiEndpoint);
        ScenarioManager.getInstance().getScenario().log("<pre><b>Status Code received from Server : </b>\n"+actualStatusCode+"</pre>");
        assertThat("The status code is not as expected", actualStatusCode, equalTo(Integer.parseInt(expectedStatusCode)));
    }

    @Then("the response should contain {int} BPIs:")
    public void theResponseShouldContainBPIs(int expectedBpiCount, List<Map<String, String>> dataTable) {
        Map<String, Object> bpis = from(apiResponse).getMap("bpi");
        ScenarioManager.getInstance().getScenario().log("<pre><b>Number of BPIs found : </b>\n"+bpis.size()+"</pre>");
        assertThat("The number of BPIs is not as expected", bpis.size(), equalTo(expectedBpiCount));
        for (Map<String, String> row : dataTable) {
            assertThat("BPI not found in response", bpis.keySet(), hasItem(row.get("BPI")));
        }
    }

    @Then("{string} description should equal {string}")
    public void theDescriptionShouldEqual(String bpi, String expectedDescription) {
        String actualDescription = from(apiResponse).getString("bpi." + bpi + ".description");
        assertThat("The description is not as expected", actualDescription, equalTo(expectedDescription));
        ScenarioManager.getInstance().getScenario().log("<pre><b>Description for BPI \"GBP\"  : </b>\n"+actualDescription+"</pre>");
    }
}
