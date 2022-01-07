package api.qa.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

public class BadRequest {
	
	@Test
	public void put_BAD_REQUEST_RequestId() {
	//This test will verify for request failure error code 400 is received when header field requestID is missing
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/BAD_REQUEST_Username.json");
		
		   given().
		   log().all().
		   when().
		   //Mandatory Header field requestId is not present
		   contentType("application/json").
		   body(file).
		   put("/user/details").
		   then().
		   assertThat().
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}
	
	@Test
	public void put_BAD_REQUEST_Username() {
	//This test will verify for request failure error code 400 is received when username is missing
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/BAD_REQUEST_Username.json");
		
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
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}
	
	
	@Test
	public void put_BAD_REQUEST_Password() {
	//This test will verify for request failure error code 400 is received when password is less than 8 character
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
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}
	
	
	@Test
	public void put_BAD_REQUEST_Email_Adress() {
	//This test will verify for request failure error code 400 is received when email address is more than 124 character
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/BAD_REQUEST_Email_Adress.json");
		
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
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}
	
	
	@Test
	public void put_BAD_REQUEST_Phone_Number() {
	//This test will verify for request failure error code 400 is received when phone number is more than 10 digits
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/BAD_REQUEST_Phone_Number.json");
		
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
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}
	
	
	@Test
	public void put_BAD_REQUEST_Country_Code() {
	//This test will verify for request failure error code 400 is received when country code is more than 2 digit
         baseURI="https://test.sit.com";
		
		//Request Body is present in file location
		File file = new File("/JsonFiles/BAD_REQUEST_Country_Code.json");
		
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
		   statusCode(400).
		   and().
		   body("errorCode",equalTo("BAD_REQUEST")).
		   and().
		   body("errorMessage",equalTo("invalid request"));
	}

}
