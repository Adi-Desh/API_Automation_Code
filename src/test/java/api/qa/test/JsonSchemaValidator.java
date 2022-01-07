package api.qa.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.io.File;
import org.testng.annotations.Test;


public class JsonSchemaValidator {
	//This test to validate Schema present in JsonSchema classpath against the json payload 
	@Test
	public void schema_Validation() {
		
		baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		
		File file = new File("/JsonFiles/payload.json");
		
		given().
		log().all().
		   when().
		   //Mandatory Header field requestId
		   header("requestId", "5809c7fc-f8d5-11eb-9a03-0242ac130003").
		   contentType("application/json").
		   body(file).
		   put("/user/details").
		   then().
		   assertThat().
		   statusCode(200);
	}

}
