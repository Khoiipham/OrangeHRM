package Pages;

import Data.PropertiesFile;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.faces.component.html.HtmlSelectOneListbox;
import java.time.Duration;


public class AdminPage {

    //Web Element....
    private final By AdminButton = By.xpath("//aside[@class='oxd-sidepanel']//li[1]");
    private final By AddUser = By.xpath("//button[normalize-space()='Add']");
    private final By UserRole = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private final By listBox = By.cssSelector("[role='listbox']");
    private final By Option = By.cssSelector("[role='option']");
    private final By AdminButton2 = By.xpath("//a[@class='oxd-main-menu-item active']");
    private final By AdminButton3= By.xpath("//a[@class='oxd-main-menu-item active']");
    private final By SelectUserRole = By.xpath("//span[text()='ESS']");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployStatus = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    private final By SelectUserStatus = By.xpath("//span[text()='Enable']");
    private final By UserName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
    private final By Password = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private final By ConfirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private final By SaveButton = By.xpath("//button[normalize-space()='Save']");
    private final By ChoseUserName = By.xpath("//div[@role='listbox']//div[1]");

    private final By FillNameIn = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private final By SearchUser = By.xpath("//button[normalize-space()='Search']");
    private final By CheckUserName = By.xpath("//div[@class='oxd-table-card']//div[2]//div[1]");
    private final By CheckUserRole = By.xpath("//div[@class='oxd-table-card']//div[3]//div[1]");
    private final By CheckEmployeeName = By.xpath("//div[contains(text(),'sww test')]");
    private final By CheckStatus = By.xpath("//div[contains(text(),'Enabled')]");

    //job..
    private final By JobButton = By.xpath("//span[normalize-space()='Job']//i[@class='oxd-icon bi-chevron-down']");
    private final By JobTitle = By.xpath("//li[@class='--active oxd-topbar-body-nav-tab --parent']//li[1]");
    private final By AddJobTitle = By.xpath("//button[normalize-space()='Add']");
    private final By JobTitleName = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private final By JD = By.xpath("//textarea[@placeholder='Type description here']");
    private final By SaveJobTitle = By.xpath("//button[normalize-space()='Save']");

    private WebDriver driver;
    private Utilities utilities;
    private Wait wait;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        utilities = new Utilities(this.driver);
        wait = new WebDriverWait(driver,  Duration.ofSeconds(5));
    }

    public void AdminPageTest() throws InterruptedException {
        System.out.println("1");
        utilities.clickElement(AdminButton);
        utilities.clickElement(AddUser);
        utilities.clickElement(UserRole);
        // Sử dụng WebDriverWait để chờ cho đến khi listbox xuất hiện
        WebElement listbox = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(listBox));
        // Chọn và click vào giá trị trong listbox
        WebElement option = listbox.findElement(By.xpath("//span[text()='ESS']"));
        option.click();

        utilities.setText(EmployeeName, "sww test");
        Thread.sleep(2000);
        utilities.clickElement(ChoseUserName);

        utilities.clickElement(EmployStatus);
        WebElement listbox2 = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(listBox));
        WebElement UserStatus = listbox2.findElement(By.xpath("//span[text()='Enabled']"));
        UserStatus.click();

        utilities.setText(UserName, "koi01");
        utilities.setText(Password,"khoi1234");
        utilities.setText(ConfirmPassword,"khoi1234");
        utilities.clickElement(SaveButton);
        Thread.sleep(2000);

        //job
        utilities.waitForPageLoaded();
        utilities.clickElement(JobButton);
        utilities.clickElement(JobTitle);
        utilities.clickElement(AddJobTitle);
        utilities.setText(JobTitleName,"Sales");
        utilities.setText(JD,"qwerty");
        utilities.clickElement(SaveJobTitle);
        System.out.println("2");
    }

    public void checkUser() throws InterruptedException {
        utilities.waitForPageLoaded();
        utilities.setText(FillNameIn,"koi01");
        Thread.sleep(2000);
        utilities.clickElement(SearchUser);
        String UserNameActual= utilities.getElementText(CheckUserName);
        String UserRoleActual= utilities.getElementText(CheckUserRole);
        String EmployeeNameActual= utilities.getElementText(CheckEmployeeName);
        String StatusActual= utilities.getElementText(CheckStatus);

        utilities.verifyEquals(UserNameActual,"koi01", "Wrong User Name");
        utilities.verifyEquals(UserRoleActual,"ESS", "Wrong User Role");
        utilities.verifyEquals(EmployeeNameActual,"sww test", "Wrong Employee Name");
        utilities.verifyEquals(StatusActual,"Enabled", "Wrong User Status");
        System.out.println("Test User passed");
    }
}
