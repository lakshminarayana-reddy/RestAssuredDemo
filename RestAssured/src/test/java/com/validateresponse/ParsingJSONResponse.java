package com.validateresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
//Approach 1
public class ParsingJSONResponse {
 // @Test
  public void validateJSONResponse() {
	  given().contentType(ContentType.JSON)
	  .when().get("http://localhost:3000/store")
	  .then().statusCode(200)
	  .header("Content-Type", "application/json; charset=utf-8")
	  .body("book[0].title", equalTo("Harry Potter"));
  }
  @Test
  public void validateJSONResponseOne() {
	 Response res = given().contentType(ContentType.JSON)
	  .when().get("http://localhost:3000/store");
	// res.then().log().all();
	 System.out.println(res);
	 Assert.assertEquals(res.getStatusCode(), 200);
	 String bookName = res.jsonPath().get("book[0].title").toString();
	 Assert.assertEquals(bookName, "Harry Potter");
	 Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	 System.out.println(res.toString());
	 JSONObject jo = new JSONObject(res.asString());
	// System.out.println(jo);
	 boolean status = false;
	 for(int i=0; i<jo.getJSONArray("book").length(); i++) {
		 String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		 System.out.println(bookTitle);
		 if(bookTitle.equals("Harry Potter")){
			 status=true;
			 break;
		 }
	 }
	 Assert.assertEquals(status, true);
	 
	 double totalPrice =0;
	 for(int j=0; j<jo.getJSONArray("book").length(); j++) {
		 String bookPrice =jo.getJSONArray("book").getJSONObject(j).get("price").toString();
		 totalPrice =totalPrice+Double.parseDouble(bookPrice);
	 }
	 System.out.println(totalPrice);
  }
}
