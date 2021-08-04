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

    @Given("User is on the login page - verify {string} displayed on the page")
    public void userIsOnTheLoginPageVerifyDisplayedOnThePage(String loginText) {
        //check that we're on the login page
        Assert.assertTrue(lp.getLoginText().getText().contains(loginText));
    }

    @When("user enter valid credentials and clicks on the Login button")
    public void userEnterValidCredentialsAndClicksOnTheLoginButton() {
        lp.enterValidEmail();
        lp.enterValidPwd();
        lp.checkRememberMeCheckbx();
        lp.clickOnLoginBtn();
    }

    @Then("Home page appears")
    public void homePageAppears() {
        hp.verifyHomePageAppears();
    }


    @When("user enters invalid email and valid pwd and clicks on the Login button")
    public void userEntersInvalidEmailAndValidPwdAndClicksOnTheLoginButton() {
            lp.enterInvalidEmail();
            lp.enterValidPwd();
            lp.checkRememberMeCheckbx();
            lp.clickOnLoginBtn();
    }


    @Then("error message {string} appears")
    public void errorMessageAppears(String message) {
        Assert.assertTrue(lp.getErrorNoCustomerAccount().getText().contains(message));
    }

    @When("user enters valid email and invalid pwd and clicks on the Login button")
    public void userEntersValidEmailAndInvalidPwdAndClicksOnTheLoginButton() {
            lp.enterValidEmail();
            lp.enterInvalidPwd();
            lp.clickOnLoginBtn();
    }


    @Then("the error message {string} appears")
    public void theErrorMessageAppears(String message) {
            Assert.assertTrue(lp.getErrorCredentialsAreIncorrect().getText().contains(message));
    }


    @When("user leaves email and pwd fields blank and clicks on the Login button")
    public void userLeavesEmailAndPwdFieldsBlankAndClicksOnTheLoginButton() {
            lp.clickOnLoginBtn();
    }
}
