package org.OpenWeatherMap_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class Stations_Link {
	
	WebDriver driver;
	public  Stations_Link(WebDriver Idriver){
			
			this.driver = Idriver;
		}
		
		// Finding Web Elements of API link Page
		
		@FindBy(xpath="//a[contains(text(),'Stations')]") WebElement stations_Link;

		@FindBy(xpath="html/body/main/div[1]/div/div/div[1]/h1") WebElement verifyHeader;
		
		public void click_stations_Link()
		{
			stations_Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
				//Weather API
			}
		}
		public void verify_stations_PageHeader()
		{
			String verifyHeader_Text = verifyHeader.getText();
			System.out.println("Actaul Header is "+verifyHeader_Text);
			
			String Expected_HeaderText= "Weather stations";
			
			Assert.assertEquals(Expected_HeaderText, verifyHeader_Text);
		}
}
