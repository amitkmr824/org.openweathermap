package org.OpenWeatherMap_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.settings.DataProviderSettings;

import org.testng.Assert;

public class Search_City {
	
WebDriver driver;
	
	public  Search_City(WebDriver Idriver){
		
		this.driver = Idriver;
	}
	
	// Finding Web Elements on Home Page
	
	@FindBy(xpath="//form[@id='searchform']/div/input")WebElement searchCityText;
	@FindBy(xpath=".//*[@id='searchform']/button")WebElement searchButton;
	
	
	@FindBy(xpath=".//*[@id='forecast_list_ul']/div") WebElement messageText;
	@FindBy(xpath=".//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/b[1]") WebElement validCitydetails;
	public void invalidCity_SearchFunctionality()
	{
		// Entering Invalid City Name in the search box
		searchCityText.sendKeys(DataProviderSettings.getConfig().inValidCity());
		// Click on Search Button-->
		searchButton.click();
		// wait for result 
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
			e.getMessage();
		}
	// Expected alert:-
		String exp = "×\n" + 
				"Not found";
		// Actual AlertMessage -->
		//messageText.
		String actual_alert_Message = messageText.getText();
		
		// Printing the actual_alert_Message on console 
		System.out.println("Actual alert message " +actual_alert_Message);
		
		Assert.assertEquals(exp, actual_alert_Message);
	
	}
	public void validCitySearch_Functionality()
	{
		
		// Entering Valid City Name in the search box
				searchCityText.sendKeys(DataProviderSettings.getConfig().validCity());
				// Click on Search Button-->
				searchButton.click();
				// wait for result 
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					
					e.getMessage();
				}
				String validCityName = validCitydetails.getText();
				System.out.println("Details of Weather for " + validCityName);
		
	}
}
