package utils;

import io.cucumber.java.After;

public class Hooks extends Base{

    @After
    //Close the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
