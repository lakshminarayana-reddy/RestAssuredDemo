package com.authorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BasicAuth {
  @Test
  public void testBasicAuthorization() {
	  given()
	  .auth().basic("postman","password")
	  .when().get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated",equalTo(true))
	  .log().all();
  }
}
