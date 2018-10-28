package org.settings;

import org.dataProvider.ConfigDataProvider;
import org.dataProvider.ExcelDataProvider;

public class DataProviderSettings {
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider con = new ConfigDataProvider();
		return con;
	}
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider exc = new ExcelDataProvider();
		return exc;
	}
	
	

}
