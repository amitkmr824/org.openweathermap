package org.OpenWeatherMap_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public  HomePage(WebDriver Idriver){
		
		this.driver = Idriver;
	}
	
	// Finding Web Elements on Home Page
	

	public void home_PageTitle()
	{
		// Expected Title -->
		String expected_Title = "Current weather and forecast - OpenWeatherMap";
		
		// Actual Title -->
		String actual_Title = driver.getTitle();
		// Printing the actual titile on console 
		System.out.println("Actual Title is " +actual_Title);
		
		// comparing the actual and expected title -->
		Assert.assertEquals(expected_Title, actual_Title);
		
	/*if(actual_Title.contains(expected_Title))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}*/
		
		
	}

}
