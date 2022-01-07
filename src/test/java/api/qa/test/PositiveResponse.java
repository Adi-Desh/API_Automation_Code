package api.qa.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class PositiveResponse {
	
	@Test
	public void POS_All_fields() {
		//This test to validate positive flow with all mandatory and optional fields
		baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		//String file = generateStringFromResource("/JsonFiles/Complete_Payload.json");
		File file = new File("/JsonFiles/Complete_Payload.json");
		
		given().
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
	
	
	@Test
	public void POS_Mandatory_fields() {
		//This test to validate positive flow with only mandatory fields
		baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/Mandatory_Fields_Payload.json");
		
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
