package RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@Listeners(RestUtils.extentreport.class)

public class RestAssuredGet {
	
	
	
	@Test
	public void weatherdetails() {
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/employee";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response res = httpRequest.request(Method.GET,"/11");
		
		String Resp = res.body().asPrettyString();
		
		
		System.out.println("response:"+Resp);
		
		int	 stcode = res.getStatusCode();
		String stline = res.getStatusLine();
		
		System.out.println("statusline:"+stline);
		

		Assert.assertEquals(200, stcode);
		Assert.assertEquals("HTTP/1.1 200 OK", stline);
		
		String  age = res.jsonPath().get("data.employee_name");
		
System.out.println("age:"+		age);
		
		
		
		
		
		
	
		
	}

}
