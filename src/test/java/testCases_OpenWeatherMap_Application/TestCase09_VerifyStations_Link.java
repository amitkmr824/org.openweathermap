package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.API_Link;
import org.OpenWeatherMap_Pages.Maps_Link;
import org.OpenWeatherMap_Pages.Stations_Link;
import org.OpenWeatherMap_Pages.WeatherInYourCity_Search;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase09_VerifyStations_Link extends BaseTestReport{
	
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_Stations_Link()
	{
		test = extent.createTest("Verify Stations Link Page");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		Stations_Link stations = PageFactory.initElements(driver, Stations_Link.class);
		stations.click_stations_Link();
		stations.verify_stations_PageHeader();
		
	}	

}
