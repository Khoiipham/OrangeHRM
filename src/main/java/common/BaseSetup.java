package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
private WebDriver driver;

static String Driverpath = "resources\\drivers\\";

public WebDriver getdriver(){
    return driver;
    }

    public WebDriver setdriver(String browserType){
        switch (browserType.trim().toLowerCase()){
            case "chrome":
                driver = InitChromeDriver();
                break;
            case "firefox":
                driver = InitFireFoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = InitChromeDriver();
                break;
        }
        return  driver;
    }

    public WebDriver InitChromeDriver(){
    System.out.println("Launching Chrome browser...");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
    }

    public WebDriver InitFireFoxDriver(){
        System.out.println("Launching FireFox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
