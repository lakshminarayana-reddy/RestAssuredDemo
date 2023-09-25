package com.serializationanddeserializarion;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {
	@Test
	public void pojoToJson() throws JsonProcessingException {
		POJOData data = new POJOData();
		data.setName("Sai");
		data.setPhone("123456");
		data.setLocation("Hyderabad");
		String arr[] = {"Java","Selenium"};
		data.setCourses(arr);
		
		//Converting Java Object to JSON Object (Serialization)
		ObjectMapper mapper = new ObjectMapper(); //Import from Jackson library
		String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsonData);
		
	}
}
