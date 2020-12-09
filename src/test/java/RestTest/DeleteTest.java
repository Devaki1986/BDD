package RestTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import RestUtils.testutil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteTest {
	
	@Test
	public void DeleteTest() {
		
		Response rep=
		
		given()
		.when()
		  .delete("http://dummy.restapiexample.com/api/v1/delete/18")
		 .then()
		 	.statusCode(200)
		 	.log().all()
		 	.extract().response();	
		 	
		 	
		String response = rep.asString();
		
		
	//	Assert.assertTrue(response.contains("success"));
		
	
	}
}
