package com.serializationanddeserializarion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class POJOData {
	String name;
	String location;
	String Phone;
	String[] Courses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@JsonProperty("Phone")
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	@JsonProperty("Courses")
	public String[] getCourses() {
		return Courses;
	}
	public void setCourses(String[] Courses) {
		this.Courses = Courses;
	}
	
}
