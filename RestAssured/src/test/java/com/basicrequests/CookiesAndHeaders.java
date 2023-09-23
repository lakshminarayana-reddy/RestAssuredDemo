package com.basicrequests;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesAndHeaders {
  @Test
  public void cookies() {
	  given().when().get("https://www.google.com/")
	  .then()
	 // .cookie("AEC","Ad49MVHaReukfLMN9ARvJX0Eld4cqFOuL08Q3ga5o_oQUVw3W60_kKVIeA")
	  .log().headers();
  }
 // @Test
  public void getCookieInfo() {
	  Response res =given().when().get("https://www.google.com/");
	  //get values of single cookie
	  String cookieVal =res.getCookie("AEC");
	  System.out.println(cookieVal);
	 
	  //get all cookies info
	  Map<String, String> map =res.getCookies();
	  System.out.println(map.keySet());
	  for(String key :map.keySet()) {
		  System.out.println(key+" "+res.getCookie(key));
	  }
  }
 // @Test
  public void getHeadersInfo() {
	  given().when().get("https://www.google.com/")
	  .then().header("Content-Type", "text/html; charset=ISO-8859-1")
	  .header("Content-Encoding", "gzip")
	  .and()
	  .header("Server","gws");
  }
 // @Test
  public void headersInfo() {
	  Response res =given().when().get("https://www.google.com/");
	  String headerVal =res.getHeader("Content-Type");
	  System.out.println(headerVal);
	  
	  //get values of all headers
	  Headers headers =res.getHeaders();
	  for(Header header : headers) {
		  System.out.println(header.getName()+"  "+header.getValue());
	  }
  }
}
