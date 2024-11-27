package Pages;

import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    private WebDriver driver ;
    private Utilities utilities;

    //web element
    private final By PIMbutton = By.xpath("//span[normalize-space()='PIM']");

    private final By AddUserButton = By.xpath("//button[normalize-space()='Add']");
    private final By Fname = By.xpath("//input[@placeholder='First Name']");
    private final By Mname = By.xpath("//input[@placeholder='Middle Name']");
    private final By Lname = By.xpath("//input[@placeholder='Last Name']");
    private final By EmployID = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]");
    private final By AddImage = By.className("oxd-file-input");
    private final By Detail = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
    private final By Username = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='orangehrm-employee-container']/div[@class='orangehrm-employee-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]");
    private final By Passw = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private final By Status = By.xpath("//label[normalize-space()='Disabled']");
    private final By ConfirmPassw = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private final By SaveButton = By.xpath("//button[normalize-space()='Save']");

    //check inform
    private final By EmployeeListButton = By.xpath("//a[normalize-space()='Employee List']");
    private final By SearchID = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private final By IDSearching = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]");
    private final By NameSearching = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]");
    private final By LnameSearching = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[4]");
    private final By SearchButton = By.xpath("//button[normalize-space()='Search']");


    public PIMPage(WebDriver driver){
        this.driver = driver;
        utilities = new Utilities(this.driver);
    }

    public void AddUser() throws InterruptedException {
        utilities.clickElement(PIMbutton);
        utilities.waitForPageLoaded();
        utilities.clickElement(AddUserButton);
        utilities.setText(Fname,"Pham");
        utilities.setText(Mname,"khoi");
        utilities.setText(Lname,"khoii");

        driver.findElement(EmployID).sendKeys(Keys.CONTROL + "a");
        driver.findElement(EmployID).sendKeys(Keys.DELETE);
    utilities.setText(EmployID,"451");
        Thread.sleep(2000);
        utilities.setText(AddImage,"D:\\be Nhi\\02d0fc6561199361282618c3c58bcadd.jpg");
        utilities.clickElement(Detail);
        utilities.setText(Username,"khoiiP");
        utilities.clickElement(Status);
        utilities.setText(Passw,"khoi12345");
        utilities.setText(ConfirmPassw,"khoi12345");
        utilities.clickElement(SaveButton);
        Thread.sleep(2000);
    }

    public void checkInform() throws InterruptedException {
    utilities.waitForPageLoaded();
    utilities.clickElement(EmployeeListButton);

    utilities.setText(SearchID,"451");
    utilities.clickElement(SearchButton);
    utilities.waitForElementVisible(IDSearching);

    String CheckID = utilities.getElementText(IDSearching);
    String CheckName = utilities.getElementText(NameSearching);
    String CheckLname = utilities.getElementText(LnameSearching);
    utilities.verifyEquals(CheckID,"451","Wrong ID");
    utilities.verifyEquals(CheckName,"Pham khoi","Wrong Name");
    utilities.verifyEquals(CheckLname,"khoii","Wrong Last Name");
        Thread.sleep(2000);
    }

}
