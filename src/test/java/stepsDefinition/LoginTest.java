package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import utils.Base;
import java.io.IOException;

public class LoginTest {

    WebDriver driver = Base.getDriver();
    LoginPage lp = new LoginPage(driver);
    HomePage hp = new HomePage(driver);

        public LoginTest() throws IOException {
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        //check that we're on the login page
        Assert.assertTrue(lp.getLoginText().getText().contains("Welcome, Please Sign In!"));
    }

    @Then("Home page appears")
    public void homePageAppears() {
        Assert.assertTrue(hp.getCustomerInfo().getText().contains("syst@email.com"));
    }


    @When("user logs in with login {string} and password {string}")
    public void userLogsInWithLoginUsernameAndPasswordPassword(String login, String pwd) {
        lp.getEmailFld().sendKeys(login);
        lp.getPasswdFld().sendKeys(pwd);
        lp.clickOnLoginBtn();
    }

    @Then("Error {string} appears")
    public void errorMessageAppears(String message) {
        Assert.assertTrue(lp.getErrMessage().contains(message));
    }


}
