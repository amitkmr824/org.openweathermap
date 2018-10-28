package org.OpenWeatherMap_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class API_Link {
	
	WebDriver driver;
	public  API_Link(WebDriver Idriver){
			
			this.driver = Idriver;
		}
		
		// Finding Web Elements of API link Page
		
		@FindBy(xpath="//a[contains(text(),'API')]") WebElement API_Link;

		@FindBy(xpath="html/body/main/div[1]/div/div/div[1]/h1") WebElement verifyHeader;
		public void click_API_Link()
		{
			API_Link.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
				//Weather API
			}
		}
		public void verify_APIPageHeader()
		{
			String verifyHeader_Text = verifyHeader.getText();
			System.out.println("Actaul Header is "+verifyHeader_Text);
			
			String Expected_HeaderText= "Weather API";
			
			Assert.assertEquals(Expected_HeaderText, verifyHeader_Text);
		}
}
