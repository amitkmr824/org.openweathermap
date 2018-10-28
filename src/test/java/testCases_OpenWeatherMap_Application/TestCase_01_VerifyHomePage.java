package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.testng.annotations.Test;

import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase_01_VerifyHomePage extends BaseTestReport{
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_VerifyHomePage_Title()
	{
		test = extent.createTest("Verify Home Page Title");
		driver = BrowserSettings.getBrowser("firefox");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.home_PageTitle();
		
		
	}


}
