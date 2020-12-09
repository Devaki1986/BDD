package com.qa.tsr.TestPage;

import java.net.MalformedURLException;
import java.net.URL;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tsr.base.TestBase;
import com.qa.tsr.pages.HomePage;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;





public class HomePageTest extends TestBase {
	
	HomePage hm;
	
	public static WebDriver driver;
	
	public HomePageTest() {
		
		super();
	}

	@BeforeMethod
	public void setup()  {
		
		 DeviceFarmClient client  = DeviceFarmClient.builder().region(Region.AP_SOUTH_1).build();
		 CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
	                .expiresInSeconds(300)        // 5 minutes
	                .projectArn("arn:aws:devicefarm:us-west-2:348246439559:testgrid-project:ceaaab39-6b23-4f27-a51e-98856999be00")
	                .build();
		URL testGridUrl = null;
	        
	            CreateTestGridUrlResponse response = client.createTestGridUrl(request);
	           try {
				testGridUrl = new URL(response.url());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	      	    //   Assertions.assertNotNull(testGridUrl);
	        
	      DesiredCapabilities desired_capabilities = new DesiredCapabilities();
	        desired_capabilities.setCapability("browserName","chrome");
	        desired_capabilities.setCapability("browserVersion", "latest");
	        desired_capabilities.setCapability("platform", "windows");
	        // Or
	   //     DesiredCapabilities desired_capabilities1 = DesiredCapabilities.firefox();
	        driver = new RemoteWebDriver(testGridUrl, desired_capabilities);
		//initialization();
		hm = new HomePage();
		
	}
	
	
	@Test
	public void HomePageVerification1() {
		
		Boolean b = hm.HomeVerification();
		Assert.assertEquals(true, b);
	}
	
	
	@Test 
	public void HomePageTitle() {
		
		String Title = hm.HomeTitle();
		
		Assert.assertEquals("Technical Stock Screener, Charts, Fundamental, F&O Analysis, India", Title);
		
	}
	
	
	@Test
	
	public void HomeVerification1() {
		String title1 = hm.HomeVerification2();
		Assert.assertEquals("Technical Stock Screener, Technical Analysis of Stocks,  Fundamental Screener, F&O Screener",title1);
		
	}
	
	@AfterMethod
	
	public void Teardown() throws InterruptedException
	{
		Thread.sleep(10000);
		
		
		driver.quit();
	}
	
}
