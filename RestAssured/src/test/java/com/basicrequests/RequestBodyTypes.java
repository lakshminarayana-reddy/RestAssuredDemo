package com.basicrequests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
/*Different ways to create POST request body
 * 1.Using HashMap
 * 2.Using org.json
 * 3.using POJO class (Plain old Java Object)
 * 4.Using external json file data.
 */
public class RequestBodyTypes {
	@Test(priority=1)
	public void hashMapBody() {
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.put("name","Harry");
		data.put("location","Hogwarts");
		data.put("Phone", "9.3/4");
		String courses[] = {"Evil Battle", "Potion Making"};
		data.put("Courses", courses);

		given().contentType("application/json").body(data)
		.when().post("http://localhost:3000/students")
		.then().statusCode(201)
		.body("name",equalTo("Harry"))
		.body("location",equalTo("Hogwarts"))
		.body("Phone",equalTo("9.3/4"))
		.body("Courses[0]", equalTo("Evil Battle"))
		.body("Courses[1]", equalTo("Potion Making"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	@Test(priority=2)
	public void delHashMapRequest() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200).log().all();
	}
	@Test(priority=3)
	public void jsonLibrary() {
		JSONObject data = new JSONObject();
		data.put("name","Hermoine");
		data.put("location","Hogwarts");
		data.put("Phone","489");
		String courses[] = {"Planting","PD"};
		data.put("Courses", courses);

		given().contentType("application/json").body(data.toString())
		.when().post("http://localhost:3000/students")
		.then().statusCode(201)
		.body("name",equalTo("Hermoine"))
		.body("location", equalTo("Hogwarts"))
		.body("Phone",equalTo("489"))
		.body("Courses[0]", equalTo("Planting"))
		.body("Courses[1]",equalTo("PD")).log().all();
	}
	@Test(priority=4)
	public void delJsonLibraryRequest() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200).log().all();
	}

	@Test(priority=5)
	public void pojo() {
		POJOData data = new POJOData();
		data.setName("Dobby");
		data.setLocation("Hogwarts");
		data.setPhone("1234");
		String courses[] = {"Helping","fighting"};
		data.setCourses(courses);

		given().contentType("application/json").body(data)
		.when().post("http://localhost:3000/students")
		.then().statusCode(201)
		.body("name",equalTo("Dobby"))
		.body("location",equalTo("Hogwarts"))
		.body("phone",equalTo("1234"))
		.body("courses[0]",equalTo("Helping"))
		.body("courses[1]", equalTo("fighting")).log().all();
	}
	@Test(priority=6)
	public void delPOJORequest() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200).log().all();
	}
	@Test(priority=7)
	public void jsonFile() throws FileNotFoundException {
		File f = new File(".\\data.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		given().contentType("application/json").body(data.toString())
		.when().post("http://localhost:3000/students")
		.then().statusCode(201)
		.body("name", equalTo("Ron"))
		.body("location", equalTo("Hogwarts"))
		.body("phone",equalTo("564"))
		.body("courses[0]",equalTo("Eating"))
		.body("courses[1]",equalTo("Sleeping")).log().all();
	}
	@Test(priority=8)
	public void delJSONFileRequest() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200).log().all();
	}
}
