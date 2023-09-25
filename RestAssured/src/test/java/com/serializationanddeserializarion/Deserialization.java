package com.serializationanddeserializarion;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {
  @Test
  public void jsonToPojo() throws JsonMappingException, JsonProcessingException {
	  String jsonData = "{\n"
	  		+ "  \"name\" : \"Sai\",\n"
	  		+ "  \"location\" : \"Hyderabad\",\n"
	  		+ "  \"courses\" : [ \"Java\", \"Selenium\" ],\n"
	  		+ "  \"phone\" : \"123456\"\n"
	  		+ "}";
	  //Converting JsonData into POJO Object
	  ObjectMapper mapper = new ObjectMapper();
	  POJOData pojoData = mapper.readValue(jsonData,POJOData.class);
	  System.out.println("Name:"+pojoData.getName());
	  System.out.println("Location:"+pojoData.getLocation());
	  System.out.println("Phone:"+pojoData.getPhone());
	  System.out.println("Courses1:"+pojoData.getCourses()[0]);
	  System.out.println("Courses2"+pojoData.getCourses()[1]);
  }
}
