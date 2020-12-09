package RestTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import RestUtils.testutil;
import io.restassured.RestAssured;


public class PutTest {
	
	public static HashMap<String,String>map=new HashMap<String, String>();
	public static testutil ts;
	
	@BeforeClass
	public void putrequest() {
		
		map.put("name", testutil.name());
		map.put("salary", testutil.salary());
		
	//	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	//	RestAssured.basePath = "/update/11";
	}
	
	@Test
	
	public void testput()
	{
	 given()
	 	.contentType("application/json")
	 	.when()
		.put("http://dummy.restapiexample.com/api/v1//update/11")
	  .then()
		.statusCode(200)
		.log().all();
		System.out.println("i am in thread" + Thread.currentThread().getId());
		
	}
	
@Test
	
	public void testput1()
	{
	 given()
	 	.contentType("application/json")
	 	.when()
		.put("http://dummy.restapiexample.com/api/v1//update/10")
	  .then()
		.statusCode(200)
		.log().all();
	 System.out.println("i am in thread" + Thread.currentThread().getId());
	}
	
	

}
