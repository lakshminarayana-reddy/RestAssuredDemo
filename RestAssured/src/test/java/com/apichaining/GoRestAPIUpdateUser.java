package com.apichaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

public class GoRestAPIUpdateUser {
  @Test
  public void updateUser(ITestContext context) {
	  
	  Faker faker = new Faker();
	  JSONObject data = new JSONObject();
	  data.put("name", faker.name().fullName());
	  data.put("email",faker.internet().emailAddress());
	  data.put("gender","male");
	  data.put("status","inactive");
	  
//	  int id = (int) context.getAttribute("userId");
	  int id = (int) context.getSuite().getAttribute("userId");
	  String bearerToken ="1ee2aa1ff6f7406cfaa0e647c5ff1375d7b48780275421beda4839acc0b80b6f";
	  given()
	  .headers("Authorization","Bearer "+bearerToken)
	  .contentType("application/json")
	  .pathParam("id",id)
	  .body(data.toString())
	  .when().put("https://gorest.co.in/public/v2/users/{id}")
	  .then().statusCode(200).log().all();
	  
  }
}
