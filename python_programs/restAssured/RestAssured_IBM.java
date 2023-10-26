package restAssured;

import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssured_IBM {

	public static void main(String[] args) {
	}

	public static void validateGenderAPI(String name,String expectedGender) {
		//API call config
		RestAssured.baseURI="https://api.genderize.io/";
		RequestSpecification req= RestAssured.given();
		
		//Response res=RestAssured.given().queryParam("name", name).get().then().extract().response();
		
		//Set request details with req object
		req.queryParam("name", name);
		Response res= req.get();
		
		//Get Data from Response object
		int statusCode=res.getStatusCode();
	//	System.out.println("status code is "+ statusCode);
	//	System.out.println("status line is "+ res.getStatusLine());
	//	System.out.println("content type "+ res.getHeader("Content-Type"));
		
		//Get all the headers from response object
		Headers resHd= res.getHeaders();
		for(Header h :resHd) {
		//	System.out.print("name:- "+h.getName());
		//	System.out.println("  value:- "+ h.getValue());
		}
		
		//get response body
		ResponseBody resBody= res.getBody();
		JsonPath path= resBody.jsonPath();
		
		assertEquals(name, path.getString("name"));
		assertEquals(expectedGender, path.getString("gender"));
	}

}
