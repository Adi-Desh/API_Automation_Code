package api.qa.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Database_Integrity {
	
	@DataProvider(name="dataForGetRequest")
	public Object[][] dataForGetRequest() {
		//dataForGetRequest will contain list of users created by Put method
		Object[][] data= new Object[2][3];
		
		data[0][0]="user1";
		data[0][1]="password1";
		data[0][2]="responseId1";
		
		data[1][0]="user2";
		data[1][1]="password2";
		data[1][2]="responseId2";
		
		return data;
		
	}
	
	
	@Test(dataProvider="dataForGetRequest")
	public void get_User_API(String userName,String password,String responseId ) {
	//This test will verify DB integrity. The user created with Put request should be displayed in response
		baseURI="https://test.sit.com";
		given().
		log().all().
		   get("/user/"+userName).
		then().
		   assertThat().
		   statusCode(200).
		   and().
		   body("userName",equalTo(userName)).
		   and().
		   body("password",equalTo(password)).
		   and().
		   header("responseId",equalTo(responseId));
	}

}
