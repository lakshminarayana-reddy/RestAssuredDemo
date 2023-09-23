package com.basicrequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryAndPathParams {
  @Test
  public void queryAndPathParams() {
	  given()
	  .pathParam("endPoint","users")
	  .queryParam("page", 2)
	 // .queryParam("id", 5)
	  .when().get("https://reqres.in/api/{endPoint}").then().statusCode(200).log().body();
  }
}
