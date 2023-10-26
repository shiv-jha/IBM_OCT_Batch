package restAssured;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateAPI {

	@Test
	void testGenderAPI() {
		RestAssured_IBM.validateGenderAPI("shiv","male");
		RestAssured_IBM.validateGenderAPI("amita","female");
		RestAssured_IBM.validateGenderAPI("abdul","male");	
		RestAssured_IBM.validateGenderAPI("null","male");	
	}
	
	@Test
	void testUniversityAPI() {
		UniversityAPI.findUniversityCountinState("india","Karnataka",14);
		UniversityAPI.checkWhetherUniversityExist("india", "Gujarat Ayurved University",true);	
	}
	
	@Test
	void testAuthBasedAPI() {
		AuthBasedAPI.testAuthBasedAPIWithCredentials("postman", "password",200);
		AuthBasedAPI.testAuthBasedAPIWithCredentials("postman", "password1",401);
	}
	
	@Test
	void testPostAPI() {
		String reqBody1= "{\"id\": 0,\"petId\": 0,\"quantity\": 0,\"shipDate\": \"2023-10-19T04:21:55.067Z\",\"status\": \"placed\",\"complete\": true}";
		String reqBody2= "{\"id\": 0,\"petId\": 0,\"quantity\": 0,\"shipDate\": \"2023-10-19T04:21:55.067Z\",\"status\": \"placed\"}";
		TestPostApi.testPost1(reqBody1,true);
		TestPostApi.testPost1(reqBody2,false);

	}

}
