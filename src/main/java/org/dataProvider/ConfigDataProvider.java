package org.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+ e.getMessage());
		}
		}
	public String getApplicationUrl()
	{
	  String url = prop.getProperty("url");
	  return url;
	
	}
	public String getWeatherURL()
	{
	  String url = prop.getProperty("weatherURL");
	  return url;
	
	}
	public String getWeatherNavigationurl()
	{
	  String url = prop.getProperty("weatherNavigationURL");
	  return url;
	}
	public String getChromePath()
	{
		String chromepath = prop.getProperty("Chromepath");
		return chromepath;
	}
	public String getIEPath()
	{
		String iepath = prop.getProperty("IEPath");
		return iepath;
	}
	public String getFirefoxPath()
	{
		String geckopath = prop.getProperty("Geckodriver");
		return geckopath;
	}
	// done changes here on 21062017-----
	/*public String getClientCode()
	{
		 String clientcode = prop.getProperty("ClientCode");
		  return clientcode;
	}*/
	
	public String validCity(){
		
		String valid_city = prop.getProperty("Valid_City");
		return valid_city;
	}
	public String inValidCity(){
		
		String inValidCity =prop.getProperty("Invalid_City");
		return inValidCity;
	}
	
	}


