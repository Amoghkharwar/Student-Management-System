package com.dps;

public class Student {
	private int rollNumber;
	private String fullName;
	private int marks;
	private String email;
	private String department;
	private String gender;
	public int getRollNumber() {
		return rollNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public int getMarks() {
		return marks;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartment() {
		return department;
	}
	public String getGender() {
		return gender;
	}
	public Student(int rollNumber, String fullName, int marks, String email, String department, String gender) {
		super();
		this.rollNumber = rollNumber;
		this.fullName = fullName;
		this.marks = marks;
		this.email = email;
		this.department = department;
		this.gender = gender;
	}

}
