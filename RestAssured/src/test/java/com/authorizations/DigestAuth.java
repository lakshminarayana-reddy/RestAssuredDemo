package com.authorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DigestAuth {
  @Test
  public void testDigestAuthentication() {
	  given().auth().digest("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then().statusCode(200)
	  .body("authenticated",equalTo(true)).log().all();
  }
}
