package org.OpenWeatherMap_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver Idriver) {

		this.driver = Idriver;
	}

	// Finding Web Elements on Login Page

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement Login_Link;
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement user_email;
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement Password;
	@FindBy(xpath = "//input[@name='commit']")
	WebElement submit;

	
	public void click_signINLink()
	{
		Login_Link.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	
	public void verify_LoginDetails(String User, String Pass) {

		user_email.sendKeys(User);
		Password.sendKeys(Pass);
		submit.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
