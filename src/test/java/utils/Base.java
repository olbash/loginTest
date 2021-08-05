package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {

    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\test\\java\\Utils\\conf.properties");
        prop.load(fis);

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\o.basha\\Chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        return driver;


    }




}
