
package com.qa.tsr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.tsr.base.TestBase;



public class TestUtil extends TestBase {

	public static long PageTimeOut =20;
	public static long ImplicitTimeOut =20;
	public static Workbook book;
	public static Sheet sheet;
	public static String path ="D:\\Workspace\\topstocks\\src\\main\\java\\com\\qa\\tsr\\testdata\\Search.xlsx";
	
	public static Object[][] getdata(String sheetname) {
		
		Object[][] data = null;
		try {
			
		
		FileInputStream ip = new FileInputStream(path);
		book = WorkbookFactory.create(ip);
		sheet = book.getSheet(sheetname);
		
		
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i =0; i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			
			}
			}
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(data);
		
		return data;
		
		
	}
	
	public static void Screenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("C:\\Users\\anilk\\Pictures\\Saved Pictures\\"+System.currentTimeMillis()+".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
