package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import web.manager.ScenarioManager;

public class Hooks {


    @Before
    public void beforeEachScenario(Scenario scenario){
        ScenarioManager.getInstance().setScenario(scenario);
    }

}
