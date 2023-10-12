package com.basicrequests;

import org.testng.annotations.Test;
//static imports -- it will not show as suggestions.
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HTTPRequests {
	static int id ;
 @Test(priority=1)
  public void getRequest() {
	  given().when().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id",equalTo(2)).log().all();
  }
 @Test(priority =2, dependsOnMethods = {"getRequest"})
  public void postRequest() {
	  HashMap<Object, Object> map = new HashMap<Object, Object>();
	  map.put("name","saicharan");
	  map.put("job","student");
	  given().contentType("application/json").body(map).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	  id = given().contentType("application/json").body(map).when().post("https://reqres.in/api/users").jsonPath().getInt("id");
  }
 @Test (priority=3, dependsOnMethods = {"postRequest"})
  public void putRequest() {
	  HashMap<Object, Object> updateMap = new HashMap<Object, Object>();
	  updateMap.put("name","charan");
	  updateMap.put("job", "learner");
	  given().contentType("application/json").body(updateMap).when().put("https://reqres.in/api/users/"+id).then().statusCode(200).log().all();
  }
  @Test (priority=4, dependsOnMethods = {"putRequest"})
  public void deleteRequest() {
	  given().when().delete("https://reqres.in/api/users/"+id).then().statusCode(204).log().all();
  }
}
