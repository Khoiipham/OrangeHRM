package testcases;

import Data.PropertiesFile;
import Pages.AdminPage;
import Pages.DashBroadPage;
import Pages.PIMPage;
import Pages.SignInPage;
import common.BaseSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;


public class OrangeTest {
    private WebDriver driver;
    public SignInPage signInPage;
    public Logger logger;
    public AdminPage adminPage;
    public DashBroadPage dashBroadPage;
    private PIMPage PIMpage;

    @BeforeClass
    public void Setup(){
        PropertiesFile.loadAllFiles();
        driver = new BaseSetup().setdriver(PropertiesFile.getValue("browser"));
    }

    @BeforeTest
            public void beforeTest() {
        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority =1)
    public void TestLogin() throws InterruptedException {
        logger.info("Test Login");
        signInPage = new SignInPage(driver);
        System.out.println(driver);
        driver.get(PropertiesFile.getValue("url"));
        signInPage.testSignIn(PropertiesFile.getValue("username"), PropertiesFile.getValue("password"));
        logger.info("Login successful");
    }

    @Test(priority =2)
    public void testAdminPage() throws InterruptedException {
        logger.info("Test Login");

        dashBroadPage = new DashBroadPage(driver);
        adminPage = new AdminPage(driver);

        System.out.println(driver);
        dashBroadPage.openAdminPage();
        adminPage.AdminPageTest();
        logger.info("Login successful");
    }

   @Test(priority =3)
    public void testPIMPage() throws InterruptedException {
        logger.info("Test Login");

        //dashBroadPage = new DashBroadPage(driver);
        PIMpage = new PIMPage(driver);
        System.out.println(driver);
        dashBroadPage.openPIMPage();
        PIMpage.AddUser();
        PIMpage.checkInform();
        logger.info("Login successful");
    }

    //@Test(priority = 3)
    public void CheckUser() throws InterruptedException {
        logger.info("Start checking");
        adminPage = new AdminPage(driver);
        adminPage.checkUser();
        logger.info("Finish checking");
    }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
