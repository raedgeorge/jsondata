package com.atech.json;

public class Course {

	
	private String title;
	private Double price;
	
	public Course(String title, Double price) {
		this.title = title;
		this.price = price;
	}

	public Course() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", price=" + price + "]";
	}
	
	
}
