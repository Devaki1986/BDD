package RestTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import RestUtils.testutil;
import io.restassured.RestAssured;


public class PostTest {

	public static HashMap map = new HashMap();
	
	public static testutil ts;
	
	@BeforeClass
	public void testdata() {
		
		map.put("name",ts.name() );
		map.put("job", ts.job());
		
		RestAssured.baseURI = "https://reqres.in";
				RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void posttest() {
		
		given()
		
			.contentType("application/json")
		.when()
			.post()
		  .then()
			.statusCode(201);
		
		

		     
		
	}
	
	

}
