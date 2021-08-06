package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfProperties;

public class LoginPage {

    //Initialize driver
    public WebDriver driver;
    //Constructor
    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Finding elements locators on the Login page
    @FindBy(xpath = "//H1[text()='Welcome, Please Sign In!']")
    private WebElement loginText;

    @FindBy(id = "Email")
    private WebElement emailFld;

    @FindBy(id = "Password")
    private WebElement passwdFld;

    @FindBy(id = "RememberMe")
    private WebElement remembMeChckbx;

    @FindBy(xpath = "//INPUT[@type='submit'][@value='Log in']")
    private WebElement submitBtn;

    @FindBy(xpath = "//LI[text()='No customer account found']")
    private WebElement errorNoCustomerAccount;

    @FindBy(xpath = "//LI[text()='The credentials provided are incorrect']")
    private WebElement errorCredentialsAreIncorrect;

    @FindBy(xpath = "//DIV[@class='validation-summary-errors']")
    private WebElement errorsValidator;

    //Getters for the Web Elements
    public WebElement getLoginText() {
        return loginText;
    }
    public WebElement getEmailFld() {
        return emailFld;
    }
    public WebElement getPasswdFld() {
        return passwdFld;
    }
    public WebElement getRemembMeChckbx() {
        return remembMeChckbx;
    }
    public WebElement getSubmitBtn() {
        return submitBtn;
    }
    public WebElement getErrorsValidator() {return errorsValidator; }

    //Test methods

    public String getErrMessage(){
        String error = getErrorsValidator().getText();
        return error;
    }

    public void clickOnLoginBtn(){
        getSubmitBtn().click();
    }

    public void checkRememberMeCheckbx(){ getRemembMeChckbx().click(); }

}