package com.serializationanddeserializarion;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Deserialization {
	@Test
	public void jsonToPojo() throws JsonMappingException, JsonProcessingException {
		String jsonData = "{\n"
				+ "  \"name\" : \"Sai\",\n"
				+ "  \"location\" : \"Hyderabad\",\n"
				+ "  \"Courses\" : [ \"Java\", \"Selenium\" ],\n"
				+ "  \"Phone\" : \"123456\"\n"
				+ "}";
		//Converting JsonData into POJO Object
		ObjectMapper mapper = new ObjectMapper();
		POJOData pojoData = mapper.readValue(jsonData,POJOData.class);
		System.out.println("Name:"+pojoData.getName());
		System.out.println("Location:"+pojoData.getLocation());
		System.out.println("Phone:"+pojoData.getPhone());
		System.out.println("Courses1:"+pojoData.getCourses()[0]);
		System.out.println("Courses2:"+pojoData.getCourses()[1]);
	}
	//Using Gson library
	@Test
	public void jsonToPojoUsingGson() {
		String jsonData = "{\n"
				+ "  \"name\" : \"Sai\",\n"
				+ "  \"location\" : \"Hyderabad\",\n"
				+ "  \"Courses\" : [ \"Java\", \"Selenium\" ],\n"
				+ "  \"Phone\" : \"123456\"\n"
				+ "}";
		//Converting JsonData into POJO Object
		Gson gson= new Gson();
		POJOData pojoData =gson.fromJson(jsonData, POJOData.class);
		System.out.println("Name:"+pojoData.getName());
		System.out.println("Location:"+pojoData.getLocation());
		System.out.println("Phone:"+pojoData.getPhone());
		System.out.println("Courses1:"+pojoData.getCourses()[0]);
		System.out.println("Courses2"+pojoData.getCourses()[1]);
	}
	//Using Json simple library
	@Test
	public void jsonToPojoUsingJsonSimple() throws ParseException {
		String jsonData = "{\n"
				+ "  \"name\" : \"Sai\",\n"
				+ "  \"location\" : \"Hyderabad\",\n"
				+ "  \"Courses\" : [ \"Java\", \"Selenium\" ],\n"
				+ "  \"Phone\" : \"123456\"\n"
				+ "}";
		JSONParser parser = new JSONParser();
//		try {
//			FileReader reader = new FileReader("Json Path");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Object obj =parser.parse(jsonData); // JSON data to Java Object
		JSONObject js = (JSONObject)obj; //Java Object to JSON Object
		System.out.println((String)js.get("name"));
		JSONArray arr =(JSONArray) js.get("Courses");
		String jObj =(String)arr.get(0);
		System.out.println(jObj);
	}

}
