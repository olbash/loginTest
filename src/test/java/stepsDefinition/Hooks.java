package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Base;

public class Hooks extends Base {

    @After
    //Close the browser
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
