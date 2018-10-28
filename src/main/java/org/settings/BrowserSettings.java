package org.settings;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import org.dataProvider.ConfigDataProvider;
import org.utility.*;
import org.settings.DataProviderSettings;
import org.dataProvider.ExcelDataProvider;
public class BrowserSettings {

	static WebDriver driver;
	//static String nodeurl = "http://192.168.0.102:4444/wd/hub";
	//@Parameters("Browser")
	public static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", DataProviderSettings.getConfig().getFirefoxPath());
			
			/*ProfilesIni allProfiles = new ProfilesIni();
			FirefoxProfile myprofile = allProfiles.getProfile("default");

			myprofile.setAcceptUntrustedCertificates(true);
			myprofile.setAssumeUntrustedCertificateIssuer(true);
			driver = new FirefoxDriver(myprofile);
*/			
			/*DesiredCapabilities ieCapabilities = DesiredCapabilities.firefox();
			try {
				driver = new RemoteWebDriver(new URL(nodeurl),ieCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			driver = new FirefoxDriver();
}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", DataProviderSettings.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//ConfigDataProvider a = new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver", DataProviderSettings.getConfig().getIEPath());
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			ieCapabilities.setCapability("requireWindowFocus", true);
			//ieCapabilities.setCapability("initialBrowserUrl", "http://localhost:8000");
			driver = new InternetExplorerDriver(ieCapabilities);
			//driver = new InternetExplorerDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void closeBrowser(WebDriver Idriver)
	{
		driver.quit();
	}
}
