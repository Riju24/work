package com.cognizant.model;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {

	private int id;
	private String name;
	private int marks;
	
	
	public Student() {
		super();
	}

	public Student(int id, int marks) {
		super();
		this.id = id;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", marks=" + marks + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
