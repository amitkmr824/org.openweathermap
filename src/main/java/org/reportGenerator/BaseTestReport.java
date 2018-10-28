package org.reportGenerator;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.utility.Screenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTestReport implements ITestListener{

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;


	@BeforeSuite
	public void setup() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "QA");
		htmlReporter.config().setDocumentTitle("Weather Map Accpetance Test Report");
		htmlReporter.config().setReportName("Acceptance Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " --> Test Case Failed ", ExtentColor.RED));
			String screenShotPath = Screenshot.CaptureScreenshot(driver, result.getName());
			try {
				test.addScreenCaptureFromPath(screenShotPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			

		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " --> Test Case Passed", ExtentColor.GREEN));
			
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " --> Test Case Skipped", ExtentColor.YELLOW));
		
		}

		try {
			Thread.sleep(8000);

		} catch (Exception e) {
			e.getMessage();
		}
		driver.quit();
	}

	@AfterSuite
	public void publishResult() {
    extent.flush();
}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" test case started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" test case Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" test case Failed");
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" test case Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
