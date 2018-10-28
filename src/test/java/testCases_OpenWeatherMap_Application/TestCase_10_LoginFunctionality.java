package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.HomePage;
import org.OpenWeatherMap_Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.testng.annotations.Test;

import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class TestCase_10_LoginFunctionality extends BaseTestReport{
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_Login()
	{
		test = extent.createTest("Verify Login Functionality");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.click_signINLink();
 		login.verify_LoginDetails(DataProviderSettings.getExcel().getData(0,0,0), 
 				DataProviderSettings.getExcel().getData(0, 0, 1));

		
		
	}


}
