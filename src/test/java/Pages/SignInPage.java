package Pages;

import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private Utilities utilities;

    //locators
    private final By emailInput = By.xpath("//input[@placeholder='Username']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By signInButton = By.xpath("//button[normalize-space()='Login']");

    public SignInPage(WebDriver driver){
        this.driver= driver;
        utilities = new Utilities(driver);
    }

    public DashBroadPage testSignIn(String username, String password) throws InterruptedException {utilities.waitForPageLoaded();
    utilities.setText(emailInput, username);
    utilities.setText(passwordInput, password);
    utilities.clickElement(signInButton);
    Thread.sleep(2000);
    return new DashBroadPage(driver);
    }
}
