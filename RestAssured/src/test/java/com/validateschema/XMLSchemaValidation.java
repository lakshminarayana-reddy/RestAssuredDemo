package com.validateschema;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
  @Test
  public void validateXMLSchema() {
	  given().when().get("")
	  .then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath(""));
  }
}
