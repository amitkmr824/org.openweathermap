package org.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
public static String CaptureScreenshot(final WebDriver driver, String ScreenshotName)
{

	TakesScreenshot ts = (TakesScreenshot)driver;
    File src = ts.getScreenshotAs(OutputType.FILE);
    String dest = System.getProperty("user.dir")+ "/Screenshots"+  ScreenshotName +  System.currentTimeMillis()+".png";
   // FileUtils.copyToFile(src,newFile(dest));
    try {
		FileUtils.copyFile(src, new File(dest));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error Message is "+ e.getMessage());
	}
    return ScreenshotName;
}
}
