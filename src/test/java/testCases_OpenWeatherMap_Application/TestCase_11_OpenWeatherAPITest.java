package testCases_OpenWeatherMap_Application;

import java.io.IOException;

import org.OpenWeatherMap_Pages.HomePage;
import org.OpenWeatherMap_Pages.LoginPage;
import org.OpenWeatherMap_Pages.OpenWeatherAPIResponse;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.testng.annotations.Test;

import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import junit.framework.Assert;



public class TestCase_11_OpenWeatherAPITest extends BaseTestReport{
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void test_WeatherAPI()
	{
		test = extent.createTest("Verify API Test");
		driver = BrowserSettings.getBrowser("chrome");
		driver.get(DataProviderSettings.getConfig().getWeatherURL());
		driver.navigate().to(DataProviderSettings.getConfig().getWeatherNavigationurl());
		OpenWeatherAPIResponse response = PageFactory.initElements(driver, OpenWeatherAPIResponse.class);
		WebElement webElement=driver.findElement(By.tagName("pre"));
		try {
			String ExpectedString = response.GetResponse();
			Assert.assertTrue(webElement.getText().equals(ExpectedString));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		 

		
		
	}


}
