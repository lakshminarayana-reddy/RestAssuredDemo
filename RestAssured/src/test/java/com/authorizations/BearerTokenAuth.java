package com.authorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BearerTokenAuth {
  @Test
  public void testBearerTokenAuthentication() {
	  String bearerToken = "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";
	  given().headers("Authorization","Bearer "+bearerToken)
	  .when().get("https://api.github.com/user/repos")
	  .then().statusCode(200).log().all();
  }
}
