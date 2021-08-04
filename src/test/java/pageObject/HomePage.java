package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfProperties;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Find elements on the Home page
    @FindBy(xpath = "//A[@href='/customer/info'][text()='syst@email.com']")
    private WebElement customerInfo;

    //Getters for the Web Elements
    public WebElement getCustomerInfo() {
        return customerInfo;
    }

    //Methods
    public void verifyHomePageAppears(){
        Assert.assertTrue(getCustomerInfo().getText().contains(ConfProperties.getProperty("email")));
    }
}
