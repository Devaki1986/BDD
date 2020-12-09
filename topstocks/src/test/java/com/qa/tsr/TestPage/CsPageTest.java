package com.qa.tsr.TestPage;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tsr.base.TestBase;
import com.qa.tsr.pages.CsPage;
import com.qa.tsr.util.TestUtil;

public class CsPageTest extends TestBase {

	TestUtil tu;
	CsPage cs;
	public CsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		tu = new TestUtil();
		cs = new CsPage();
		
	}
	
	@DataProvider
	public Object[][] Searching(){
		
		Object[][] data = tu.getdata("Sheet1");
		
		return data;
	}
	
	@Test(dataProvider = "Searching")
	
	public void Searchtest(String text1,String text2,String text3) {
		
		String data = cs.Search(text1,text2);
		
		Assert.assertEquals(data, text3);
		
	}
	
	@AfterMethod
	public void quit()
	{
		//driver.quit();
	}
	
}
