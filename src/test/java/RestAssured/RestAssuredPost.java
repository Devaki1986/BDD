package RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlUtils;

import RestUtils.testdatautil;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.xmlbeans.impl.common.XmlStreamUtils;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;



public class RestAssuredPost {
	
//	Logger log = Logger.getLogger(GenerateLogs.class)
	
	public static testdatautil ts;

	
	@Test(dataProvider="testdata")
	public void postest(String name,String job) {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		 
		//for basic Authentication
		
	/*PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQa");
		auth.setPassword("password"); 
		RestAssured.authentication=auth;*/
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject obj = new JSONObject();
		
		obj.put("name", name);
		obj.put("job", job);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(obj.toJSONString()); 
		
		
		
		Response rep = httpRequest.request(Method.POST,"/2");
		String response = rep.body().asPrettyString();
		
		System.out.println("response:"+response);
		
		int Statuscode = rep.statusCode();
		
		System.out.println("statuscode" +Statuscode);
		
		Assert.assertEquals(201, Statuscode);
		
		System.out.println("name:"+rep.jsonPath().get("name"));
		
		Assert.assertEquals(name, rep.jsonPath().get("name"));
		System.out.println(rep.header("Connection"));
		
		Assert.assertEquals(response.contains(name),true);
		
		Headers hed = rep.headers();
		System.out.println("headers:-----"  +hed);
		
		
	}
	
	@DataProvider()
	public Object[][] testdata(){
		
		//String[][] data= {{"anil","leader"},{"neeraja","manager"},{"mokshika","ceo"} };
		
		Object [][] data =  testdatautil.getdata("Sheet1");
	
		
		
		return data;
		
		
	}
	
	

}
