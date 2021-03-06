package utils;


import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {

    public static WebDriver driver;
    public static Properties prop; //it's a simple way, the better way see in GlobalProperties class

    public static WebDriver getDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\o.basha\\IdeaProjects\\LoginTest\\src\\test\\java\\Utils\\conf.properties");
        prop.load(fis);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\o.basha\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    @After
    //Close the browser
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }


}
