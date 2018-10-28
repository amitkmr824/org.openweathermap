package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.HomePage;
import org.OpenWeatherMap_Pages.Search_City;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase_02_VerifyInvalidCity extends BaseTestReport{
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_VerifyInvalidCity_AlertMessage()
	{
		test = extent.createTest("Verify alert Message display on enerting Invalid City in the search text");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		Search_City searchcity = PageFactory.initElements(driver, Search_City.class);
		searchcity.invalidCity_SearchFunctionality();
	}	

}
