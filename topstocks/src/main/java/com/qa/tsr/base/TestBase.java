package com.qa.tsr.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.reporters.Files;

import com.qa.tsr.util.WebEvenetListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEvenetListener eventListener;
	public static String path;
	
	public TestBase() {
		
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Workspace\\topstocks\\src\\main\\java\\com\\qa\\tsr\\config\\config.properties");
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	
	public static void initialization() {
		
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\anilk\\Downloads\\chromedriver.exe");
	//	driver = new ChromeDriver();
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEvenetListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	/*	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageTimeOut,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitTimeOut,TimeUnit.SECONDS);*/
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.topstockresearch.com/");
}
	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 path = "C:\\Users\\anilk\\Pictures\\Saved Pictures\\"+System.currentTimeMillis()+".jpeg";
			FileHandler.copy(src, new File("C:\\Users\\anilk\\Pictures\\Saved Pictures\\"+System.currentTimeMillis()+".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	
}