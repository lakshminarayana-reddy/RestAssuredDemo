package com.apichaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GoRestAPIGetUser {
  @Test
  public void getUser(ITestContext context) {
//	  int id = (int) context.getAttribute("userId");
	  int id = (int) context.getSuite().getAttribute("userId");
	  String bearerToken ="1ee2aa1ff6f7406cfaa0e647c5ff1375d7b48780275421beda4839acc0b80b6f";
	  given()
	  .headers("Authorization", "Bearer "+bearerToken)
	  .pathParam("id",id)
	  .when()
	  .get("https://gorest.co.in/public/v2/users/{id}")
	  .then()
	  .statusCode(200)
	  .log().all();
  }
}
