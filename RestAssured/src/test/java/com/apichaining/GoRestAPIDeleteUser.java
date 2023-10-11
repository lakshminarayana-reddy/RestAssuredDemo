package com.apichaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GoRestAPIDeleteUser {
  @Test
  public void deleteUser(ITestContext context) {
	  String bearerToken ="1ee2aa1ff6f7406cfaa0e647c5ff1375d7b48780275421beda4839acc0b80b6f";
//	  int id = (int) context.getAttribute("userId");
	  int id = (int) context.getSuite().getAttribute("userId");
	  given().headers("AUthorization","Bearer "+bearerToken).pathParam("id",id)
	  .when().delete("https://gorest.co.in/public/v2/users/{id}")
	  .then().statusCode(204).log().all();
  }
}
