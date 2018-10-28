package org.OpenWeatherMap_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.settings.DataProviderSettings;

import junit.framework.Assert;

public class WeatherInYourCity_Search {
	
	WebDriver driver;
public  WeatherInYourCity_Search(WebDriver Idriver){
		
		this.driver = Idriver;
	}
	
	// Finding Web Elements of Weather in Your City Search at Top of Page
	
	@FindBy(xpath=".//*[@id='nav-search']") WebElement navSearchLink;
	@FindBy(xpath="//form[@id='nav-search-form']/div/input") WebElement nav_SearchText;
	
	@FindBy(xpath="//form[@id='nav-search-form']/div/span/button") WebElement nav_SearchButton;
	
	@FindBy(xpath="html/body/main/div[1]/div/div/h2/span") WebElement verifyHeader;
	
	public void clickOn_NavSearchLink()
	{
		navSearchLink.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	public void typeCityName_SearchText()
	{
		nav_SearchText.sendKeys(DataProviderSettings.getConfig().validCity());
	}
	
	public void clickOn_NavSearchButton()
	{
		nav_SearchButton.click();
	}
	
	public void verify_SearchPageHeader()
	{
		String verifyHeader_Text = verifyHeader.getText();
		System.out.println("Actaul Header is "+verifyHeader_Text);
		
		String Expected_HeaderText= "Weather in your city";
		
		Assert.assertEquals(Expected_HeaderText, verifyHeader_Text);
	}

}
