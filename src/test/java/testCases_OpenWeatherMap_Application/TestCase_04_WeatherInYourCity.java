package testCases_OpenWeatherMap_Application;

import org.OpenWeatherMap_Pages.Search_City;
import org.OpenWeatherMap_Pages.WeatherInYourCity_Search;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCase_04_WeatherInYourCity extends BaseTestReport {
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_WeatherInYourCity_Link()
	{
		test = extent.createTest("Verify functionality of Search link-Weather in Your City on Top");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getApplicationUrl());
		WeatherInYourCity_Search search = PageFactory.initElements(driver, WeatherInYourCity_Search.class);
		search.clickOn_NavSearchLink();
		search.typeCityName_SearchText();
		search.clickOn_NavSearchButton();
		search.verify_SearchPageHeader();
	}	

}
