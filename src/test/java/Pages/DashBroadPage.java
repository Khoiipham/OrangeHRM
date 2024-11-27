package Pages;

import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBroadPage {
    private WebDriver driver;
    private AdminPage adminPage;
    private Utilities utilities;
    private PIMPage PIMpage;

    //web element
    private final By AdminButton = By.xpath("//aside[@class='oxd-sidepanel']//li[1]");
    private final By PIMbutton = By.xpath("//a[@class='oxd-main-menu-item active']");

    public DashBroadPage(WebDriver driver){
        this.driver = driver;
        //adminPage = new AdminPage(driver);
        utilities = new Utilities(this.driver);
    }

    public AdminPage openAdminPage(){
        //utilities.clickElement(AdminButton);
        //utilities.waitForPageLoaded();
        return new AdminPage(driver);
    }

    public PIMPage openPIMPage(){
        //utilities.clickElement(PIMbutton);
        //utilities.waitForPageLoaded();
        return new PIMPage(driver);
    }
}
