package restAssured;

import static org.testng.Assert.assertEquals;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UniversityAPI {

	public static void findUniversityCountinState(String country,String state, int expectedCount) {
		RestAssured.baseURI = "http://universities.hipolabs.com/";
		Response res = RestAssured.given().queryParam("country", country).get("search").then().extract().response();
		assertEquals(200, res.getStatusCode());
		ResponseBody resBody= res.getBody();
		JsonPath resPath= resBody.jsonPath();
		List<String> stateList =resPath.getList("state-province");
	//	System.out.println(stateList);
		int counter=0;
		for(int i=0;i<stateList.size();i++) {
			if(stateList.get(i)!=null) {
				if(stateList.get(i).equals(state)) {
					counter++;
				}
			}	
		}
		assertEquals(expectedCount, counter);
		
	}
	
	public static void checkWhetherUniversityExist(String country,String university,boolean isExist) {
		RestAssured.baseURI = "http://universities.hipolabs.com/";
		Response res = RestAssured.given().queryParam("country", country).get("search").then().extract().response();
		assertEquals(200, res.getStatusCode());
		ResponseBody resBody= res.getBody();
		JsonPath resPath= resBody.jsonPath();
		List<String> uniList =resPath.getList("name");
		boolean found=false;
		for( int i=0;i<uniList.size();i++) {
			if (uniList.get(i).equals(university)){
				found=true;
				break;
			}
			
		}
		assertEquals(found, isExist);
	
	}

}
