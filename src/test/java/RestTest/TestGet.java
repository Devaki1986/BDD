package RestTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGet {
	@Test
	public void getuserdetails() {
		
	
	given()
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employee/10")
		.then()
			.statusCode(200)
			//.assertThat().body("data[0].name", equalTo("cerulean"))
			.assertThat().header("Accept-Encoding",equalTo(null));
	System.out.println("i am in thread" + Thread.currentThread().getId());
}
	
	@Test
	public void getuserdetails1() {
		
	
	given()
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
			.statusCode(200)
		//	.assertThat().body("data[0].name", equalTo("cerulean"))
		//	.body("data[9].employee_name", equals("Colleen Hurst"))
			.body("data[0].employee_name", equalTo("Tiger Nixon"));
		//	.assertThat().header("Connection",equalTo("keep-alive"));
	System.out.println("i am in thread" + Thread.currentThread().getId());
}
}
