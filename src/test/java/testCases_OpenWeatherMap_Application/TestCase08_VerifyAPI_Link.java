package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.API_Link;
import org.OpenWeatherMap_Pages.Maps_Link;
import org.OpenWeatherMap_Pages.WeatherInYourCity_Search;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase08_VerifyAPI_Link extends BaseTestReport{
	
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_API_Link()
	{
		test = extent.createTest("Verify API Link Page");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		API_Link api = PageFactory.initElements(driver, API_Link.class);
		api.click_API_Link();
		api.verify_APIPageHeader();
		
	}	

}
