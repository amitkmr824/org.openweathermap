package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.Maps_Link;
import org.OpenWeatherMap_Pages.WeatherInYourCity_Search;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase_05_Maps_WeatherMaps_Link extends BaseTestReport{
	
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_Maps_WeatherMapsLink()
	{
		test = extent.createTest("Verify by clicking on Weather Maps Link, it should open successfully");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		Maps_Link maps = PageFactory.initElements(driver, Maps_Link.class);
		maps.click_Maps();
		maps.click_WeatherMaps();
		
	}	

}
