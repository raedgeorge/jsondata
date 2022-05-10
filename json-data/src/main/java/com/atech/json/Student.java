package com.atech.json;

import java.util.ArrayList;
import java.util.List;

public class Student {

	
	private int id;
	private String name;
	private String email;
	private List<Course> courses = new ArrayList<>();
	
	private Address address;

	public Student(int id, String name, String email, List<Course> courses, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.courses = courses;
		this.address = address;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + ", address="
				+ address + "]";
	}
	
}
