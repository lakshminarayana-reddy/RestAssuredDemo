package com.validateresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
  //@Test
  public void testXMLResponse() {
	  given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
	  .then().statusCode(200)
	  .header("Content-Type", "application/xml; charset=utf-8")
	  .body("TravelerinformationResponse.page", equalTo("1"))
	  .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
	  .log().all();
  }
 // @Test
  public void testXMLRespone2() {
	  Response res =given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
	  Assert.assertEquals(res.getStatusCode(), 200);
	  System.out.println(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString());
	  Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name"), "Developer");
  }
  @Test
  public void testXMLRespone3() {
	  Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
	  XmlPath xmlObj = new XmlPath(res.asString());
	  List<String> travelers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	  Assert.assertEquals(travelers.size(),10);
	  List<String> travelersName = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	  for(String name: travelersName) {
		  System.out.println(name);
	  }
  }
}
