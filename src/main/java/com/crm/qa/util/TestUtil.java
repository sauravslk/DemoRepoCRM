package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGELOADTIMEOUT = 20;
	public static long IMPLICITTIMEOUT = 30;
	public static Workbook book;
	public static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Saurav\\eclipse-workspace\\FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	public TestUtil() throws IOException
	{
		super();
	}

	public void switchToFrame()
	{
	driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetname) throws InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenShotAtTheEndOfTest() throws IOException
	{
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrfile, new File(currentDir +"/screenshots"+ System.currentTimeMillis() +".png"));
	}
}
