package com.atech;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atech.json.Address;
import com.atech.json.Course;
import com.atech.json.Student;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class JsonDataApplication {

	public static void main(String[] args) throws JSONException, StreamWriteException, DatabindException, IOException {
		SpringApplication.run(JsonDataApplication.class, args);
		
		List<Course> courses = new ArrayList<>();
		
		courses.add(new Course("Java", 35.59));
		courses.add(new Course("HTML", 15.59));
		courses.add(new Course("Spring", 25.59));
		
		
		Address address = new Address("Bethlehem", "Street 004");
		
		Student student = new Student(1, "raed", "raed@atech.com", courses, address);
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		
		student.getCourses().forEach(course -> {
			
			JSONObject json = new JSONObject();
		
			try {
			
				json.put("title", course.getTitle()).put("price", course.getPrice());
			
				jsonArray.put(json);
			}
			catch (JSONException e) {
			
				e.printStackTrace();
			}
		});
		
		jsonObject
			.put("Id", student.getId())
			.put("Name", student.getName())
			.put("Email address", student.getEmail())
			.put("Address",
						 new JSONObject().put("City", 
								 student.getAddress()
								 .getCity()).put("Street No.", student.getAddress().getStreet()))
			.put("courses", jsonArray);

		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.writerWithDefaultPrettyPrinter();
		mapper.writeValue(new File("data2.json"), jsonObject.toString());
	}

}
