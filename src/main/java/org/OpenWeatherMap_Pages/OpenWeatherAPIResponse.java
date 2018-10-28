package org.OpenWeatherMap_Pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.OpenWeatherMap_Pages.HomePage;
import org.OpenWeatherMap_Pages.LoginPage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reportGenerator.BaseTestReport;
import org.testng.annotations.Test;

import org.settings.BrowserSettings;
import org.settings.DataProviderSettings;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OpenWeatherAPIResponse {

	private final String USER_AGENT = "Mozilla/5.0";

	public String GetResponse() throws ClientProtocolException, IOException {
		StringBuffer result = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Mumbai";
		HttpGet request = new HttpGet(url);
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);
		int responseCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try {
			if (responseCode == 200)

			{
				System.out.println("Response is Successfull");
				BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					result.append(line);
					System.out.println(result.toString());
				}
			}
			return result.toString();

		} catch (Exception ex) {
			result.append("Get Response Failed");
			return result.toString();
		}

	}

}
