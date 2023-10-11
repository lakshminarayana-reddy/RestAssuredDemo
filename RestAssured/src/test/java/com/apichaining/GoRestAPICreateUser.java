package com.apichaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class GoRestAPICreateUser {
	@Test
	public void createUser(ITestContext context) {

		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("status","active");
		data.put("email",faker.internet().emailAddress());


		String bearerToken ="1ee2aa1ff6f7406cfaa0e647c5ff1375d7b48780275421beda4839acc0b80b6f";
		int id=given()
				.header("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
				.when()
				.post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		System.out.println("Generated Id: "+id);
		//context.setAttribute("userId", id); //This will work for test level in xml file
		context.getSuite().setAttribute("userId", id); // This will work for suite level in xml file.
	}
}
