package com.qa.tsr.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tsr.base.TestBase;

public class CsPage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Custom Screener')]")
	static
	WebElement Customer;
	
	@FindBy (xpath="//input[@id='user_input']")
	static
	WebElement Search;
	
	
	
	public CsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public static String Search(String text1,String text2) {
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Customer.click();
		Search.sendKeys(text1);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/a[contains(text(),'"+text2+"')]")).click();
		return driver.getTitle();
	
	}
	
}
