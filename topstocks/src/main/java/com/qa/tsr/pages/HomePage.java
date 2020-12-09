package com.qa.tsr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tsr.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//h3[contains(text(),'Nifty 50')]")
	static
	WebElement Nifty50;
	
	@FindBy(xpath = "//h1[contains(text(),'Technical Stock Screener, Technical Analysis of St')]")
	static
	WebElement Topstock;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public static String HomeTitle() {
		
		return driver.getTitle();
	}
	
	public static Boolean  HomeVerification() {
		
		System.out.println(Nifty50.toString());
		
		return Nifty50.isDisplayed();
	}
	
	public static String HomeVerification2() {
		
		System.out.println(Topstock.getText());
		
		return Topstock.getText();
		
		}
	

}
