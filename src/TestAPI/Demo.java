package TestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json")
		.body(payload.AddPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		//System.out.println(response);
		
		JsonPath js= new JsonPath(response);
		String placeId=js.getString("place_id");
		System.out.println(placeId);
		
		//Update
		
/*		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+Placeid+"\",r\n" + 
				"\"address\":\"70 Summer walk , USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));  
		
		*/
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\"70 Summer walk , USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

		
		//Get
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id","c60daac2eb4c5914119d0e27db7442f3")
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200);
	

	}

}
