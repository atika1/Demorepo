package com.qa.crm.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import come.qa.crm.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToFrame()
	{
		obj.switchTo().frame("mainpanel");
	}
	
	public static void getScreenshot() throws IOException
	{
		File srcFile = ((TakesScreenshot) obj).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile,new File(currentdir+"/screenshots"+System.currentTimeMillis()+".png"));
	}
	
	public static Object[][] getTestdata() throws IOException
	{
			
	
	FileInputStream obj1=new FileInputStream("C:\\Users\\Windows10\\Desktop\\atika1\\FreeCRMTest\\src\\main\\java\\com\\qa\\crm\\testdata\\FreeCrm_testdata.xlsx");
	XSSFWorkbook obj2=new XSSFWorkbook(obj1);
	XSSFSheet obj3=obj2.getSheet("Sheet1");
	
	int rows=obj3.getPhysicalNumberOfRows();
	System.out.println(rows);
	int cols=obj3.getRow(0).getLastCellNum();
	System.out.println(cols);
	
	Object[][] data =new Object[rows][cols];
	
	for(int i=1;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			data[i][j]=obj3.getRow(i).getCell(j).getStringCellValue();
			System.out.println(data[i][j]);
		}
	}
	
	return data;

}
}
