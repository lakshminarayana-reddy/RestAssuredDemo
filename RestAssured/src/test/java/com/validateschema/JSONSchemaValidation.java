package com.validateschema;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class JSONSchemaValidation {
  @Test
  public void validateJSONSchema() {
	  //File file = new File("C:\\Users\\baru\\JSON Files\\BooksJsonSchema.json");
	  given()
	  .when().get("http://localhost:3000/store")
	  .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("BooksJSONSchema.json"));
  }
}
