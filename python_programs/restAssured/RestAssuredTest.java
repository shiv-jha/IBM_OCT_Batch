package restAssured;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hamcrest.core.IsNull;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.json.JSONArray;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

class RestAssuredTest {

	@Test
	void verifyPostApi() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";	
		String reqBody="{\"title\":\"abc\",\"body\":\"far\",\"userid\":\"1\"}";
	//	RestAssured.given().
		Response resp = RestAssured.given().body(reqBody).post("/posts").then().extract().response();
		System.out.println("status code: "+resp.getStatusCode());
		ResponseBody respBody= resp.body();
		JsonPath respPath = respBody.jsonPath();
		System.out.println("id form response:"+respPath.getInt("id"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void verifyPositiveAuthentication(String username, String password) {
		RestAssured.baseURI = "https://postman-echo.com/";

		Response response = RestAssured.given().auth().preemptive().basic(username, password).get("/basic-auth").then()
				.extract().response();
		ResponseBody respBody = response.body();
		JsonPath respPath = respBody.jsonPath();
		assertEquals(true, respPath.getBoolean("authenticated"));
	}

	public void verifyNegativeAuthentication(String username, String password) {
		RestAssured.baseURI = "https://postman-echo.com/";
		int statusCode = RestAssured.given().auth().preemptive().basic(username, password).get("/basic-auth").then()
				.extract().response().getStatusCode();
		assertEquals(401, statusCode);

	}

	//@Test
	void verifyAuthentication() {
		verifyPositiveAuthentication("postman", "password");
		verifyNegativeAuthentication("wrong", "wrong");
		// verifyPositiveAuthentication();
	}

	public void countUniersityInState(String state) {
		RestAssured.baseURI = "http://universities.hipolabs.com";

		Response response = RestAssured.given().queryParam("country", "india").get("/search").then().extract()
				.response();
		assertEquals(200, response.getStatusCode());
		assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		ResponseBody respBody = response.body();
		JsonPath respPath = respBody.jsonPath();
		List<String> stateList = respPath.getList("state-province");

		int counter = 0;
		for (int i = 0; i < stateList.size(); i++) {
			if (stateList.get(i) != null) {
				if (stateList.get(i).equals(state)) {
					counter++;
				}
			}
		}
		System.out.println("count of university in given state is:" + counter);
	}

	public void checkWhetherUniversityExist(String university) {
		RestAssured.baseURI = "http://universities.hipolabs.com";

		Response response = RestAssured.given().queryParam("country", "india").get("/search").then().extract()
				.response();
		assertEquals(200, response.getStatusCode());
		assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		ResponseBody respBody = response.body();
		JsonPath respPath = respBody.jsonPath();
		List<String> unvList = respPath.getList("name");
		boolean found = false;
		for (int i = 0; i < unvList.size(); i++) {
			if (unvList.get(i) != null) {
				if (unvList.get(i).equals(university)) {
					found = true;
					break;
				}
			}
		}
		if (found) {
			System.out.println("given university present");
		} else {
			System.out.println("given university not present");
		}
	}

	// @Test
	void universityTest() {
		countUniersityInState("Karnataka");
		checkWhetherUniversityExist("AISECT University");
		// fetchStateOfGivenUniversity("Indian Board of Alternative Medicine");

	}

	public void testGenderApi(String name, String expectedGender) {
		RestAssured.baseURI = "https://api.genderize.io/";

		Response response = RestAssured.given().queryParam("name", name).get().then().extract().response();
		/*
		 * RequestSpecification myReq=RestAssured.given(); myReq.queryParam("name",
		 * name); Response response = myReq.get("");
		 */
		assertEquals(200, response.getStatusCode());
		assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		// System.out.println(response.getHeader("Content-Type"));
		for (Header h : response.getHeaders()) {
			// System.out.print("name:="+h.getName());
			// System.out.print(" value:="+h.getValue());
			// System.out.println();
		}
		ResponseBody respBody = response.body();
		JsonPath respPath = respBody.jsonPath();
		assertEquals(expectedGender, respPath.getString("gender"));
	}

	// @Test
	void genderfetchApi() {

		testGenderApi("shiv", "male");
		testGenderApi("seema", "female");
		testGenderApi("santosh", "male");

		/*
		 * assertEquals(200, statusCode); System.out.println(response.getStatusLine());
		 * assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		 * response.headers(); for (Header hd : response.headers()) {
		 * System.out.println("name:=" + hd.getName()); System.out.println("value:=" +
		 * hd.getValue()); } ResponseBody resBody = response.getBody(); JsonPath
		 * responsePath = response.jsonPath(); String myName = responsePath.get("name");
		 * assertEquals("shiv", myName);
		 */
	}

	// @Test
	void universityListApi() {
		RestAssured.baseURI = "http://universities.hipolabs.com/search?/";
		RequestSpecification myRequest = RestAssured.given();
		myRequest.queryParam("country", "india");
		Response response = myRequest.get("");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
		JsonPath responsePath = response.jsonPath();
		List<String> countries = responsePath.getList("country");
		List<String> names = responsePath.getList("name");
		List<String> states = responsePath.getList("state-province");
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("NorthCap University")) {
				System.out.println(states.get(i));
				break;
			}
		}
		int counter = 0;
		for (int j = 0; j < states.size(); j++) {
			if (states.get(j) != null) {
				if (states.get(j).equals("Punjab")) {
					counter++;
				}
			}
		}
		System.out.println("number of university in punjab is:" + counter);

	}

	// @Test
	public void authBasedApi() {
		RequestSpecification myReq = RestAssured.given().auth().preemptive().basic("postman", "password");
		Response response = myReq.get("https://postman-echo.com/basic-auth");
		ResponseBody resBody = response.body();
		String res = resBody.asString();
		System.out.println(res);

	}

	//@Test
	public void callPostApi() {
		String requestBody = "{\n" + "  \"title\": \"foo\",\n" + "  \"body\": \"bar\",\n" + "  \"userId\": \"1\" \n}";
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Response response = RestAssured.given().header("Content-type", "application/json").and().body(requestBody)
				.when().post("/posts").then().extract().response();
		System.out.println(response.statusCode());

	}

}
