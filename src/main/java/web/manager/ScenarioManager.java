package web.manager;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;


public class ScenarioManager {

    private static ScenarioManager obj = null;

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    private Scenario scenario;

    public static synchronized ScenarioManager getInstance(){
        if(obj == null){
            obj = new ScenarioManager();
        }
        return obj;
    }
}
