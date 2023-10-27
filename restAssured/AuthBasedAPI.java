package restAssured;


import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthBasedAPI {
	public static void testAuthBasedAPIWithCredentials(String userNm,String password,int expectedCode) {
		RestAssured.baseURI = "https://postman-echo.com/";
		Response res=	RestAssured.given().auth().preemptive().basic(userNm, password).get("basic-auth").then().extract().response();
		assertEquals(expectedCode, res.getStatusCode());
		
	}

}
