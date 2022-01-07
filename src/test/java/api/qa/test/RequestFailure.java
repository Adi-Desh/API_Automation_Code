package api.qa.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.io.File;

import org.testng.annotations.Test;

public class RequestFailure {
	
	@Test
	public void put_Request_Failure() {
	//This test will verify for request failure error code 500 is received due to duplicate username 
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
         File file = new File("/JsonFiles/payload_failure.json");
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
		   statusCode(500).
		   and().
		   body("errorCode",equalTo("FAILURE")).
		   and().
		   body("errorMessage",equalTo("update failed"));
	}

}
