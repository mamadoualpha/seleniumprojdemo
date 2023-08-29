package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReport;



//"Listener" class is extending the "Base" class and implementing the "ITestListener" interface
public class Listeners extends Base implements ITestListener {

	WebDriver driver = null;

	ExtentReports ExtentReports = ExtentReport.getExtentReport();
	ExtentTest extentTest;

	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	private com.aventstack.extentreports.ExtentReports extentReport;

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName()+" execution started");

		String testName = result.getName();
		extentTest = ExtentReports.createTest(testName);
		extentTestThread.set(extentTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		// extentTest.log(Status.PASS, testName+" Got pass");
		extentTestThread.get().log(Status.PASS, testName + " Got pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;

		String testMethodName = result.getName();
		// extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String screenshotFilePath = takeScreenshot(testMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		ExtentReports.flush();

	}

}