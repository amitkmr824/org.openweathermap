package org.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is " +e.getMessage());
		}
	}
	public String getData(int SheetIndex,int row, int column)
	{
		String data =wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String getData(String SheetName,int row, int column)
	{
		String data =wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int rowCount(String Sheetname)
	{
		return wb.getSheet(Sheetname).getLastRowNum();
	}
	
	public int rowCount(int SheetIndex)
	{
		return wb.getSheetAt(SheetIndex).getLastRowNum();
	}
}
