package restAssured;

import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestPostApi {
	
	public static void testPost1(String reqBody,boolean  complete) {
		RestAssured.baseURI="https://petstore.swagger.io/";
		Response res= RestAssured.given().header("Content-type", "application/json").body(reqBody).post("v2/store/order").then().extract().response();
		ResponseBody resBody = res.getBody();
		JsonPath resPath = resBody.jsonPath();
		assertEquals(complete, resPath.getBoolean("complete")) ;	
	}
}
