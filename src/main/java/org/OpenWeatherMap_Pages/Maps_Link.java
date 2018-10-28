package org.OpenWeatherMap_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Maps_Link {
	
	WebDriver driver;
	public  Maps_Link(WebDriver Idriver){
			
			this.driver = Idriver;
		}
		
		// Finding Web Elements of Maps Page
		
		@FindBy(xpath="//a[contains(text(),'Maps')]") WebElement Maps_Link;
		@FindBy(xpath="//a[contains(text(),'Weather maps')]") WebElement WeatherMaps_Link;
		@FindBy(xpath="//a[contains(text(),'Current satellite maps')]") WebElement Current_SateliteMaps_link;
		@FindBy(xpath="//a[contains(text(),'Beautiful places')]") WebElement BeautifulPlaces_Link;

		
		public void click_Maps()
		{
			Maps_Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		public void click_WeatherMaps()
		{
			WeatherMaps_Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		public void click_Current_SateliteMaps()
		{
			Current_SateliteMaps_link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		public void click_BeautifulPlaces()
		{
			BeautifulPlaces_Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		
		
}
