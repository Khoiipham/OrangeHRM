package reportpack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtendReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    @Override
    public void onStart(ITestContext TestContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
        repName = "Test-Report-"+timeStamp+".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //specify location of report
        sparkReporter.config().setDocumentTitle("HRM");
        sparkReporter.config().setReportName("Create Clients test"); //name of report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","OrangeHRM");
        extent.setSystemInfo("Operation System",System.getProperty("os.name"));
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Khoi");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Case Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    test = extent.createTest(result.getName());
    test.createNode(result.getName());
    test.assignCategory(result.getMethod().getGroups());

    test.log(Status.FAIL, "Test Failed");
    test.log(Status.FAIL,result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP,result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    @Override
    public void onFinish(ITestContext TestContext) {
    extent.flush();
    }
}
