package com.authorizations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIKeyAuth {
  @Test
  public void testAPIKeyAuthentication() {
	  given().queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
	  .when().get("api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
	  .then().statusCode(200).log().all();
  }
}
