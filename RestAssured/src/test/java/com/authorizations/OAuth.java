package com.authorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class OAuth {
 // @Test
  public void testOAuthOneAuthentication() {
	  given().auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrat")
	  .when().get("url")
	  .then().statusCode(200).log().all();
  }
  @Test
  public void testOAuthTwoAuthentication() {
	  given().auth().oauth2("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")
	  .when().get("https://api.github.com/user/repos")
	  .then().statusCode(200).log().all();
  }
}
