package com.cvt.student_manager.beans;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String roll, name, yearOfJoining, dob, currentClass;

	// Getter method for Student's name
	public String getName() {
		return name;
	}

	// Setter method for Student's name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for Student's Date of Birth
	public String getDob() {
		return dob;
	}

	// Setter method for Student's Date of Birth
	public void setDob(String dob) {
		this.dob = dob;
	}

	// Getter method for Student's Roll number
	public String getRoll() {
		return roll;
	}

	// Setter method for Student's Roll number
	public void setRoll(String roll) {
		this.roll = roll;
	}

	// Getter method for Student's Year of Joining
	public String getYearOfJoining() {
		return yearOfJoining;
	}

	// Setter method for Student's Year of Joining
	public void setYearOfJoining(String yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	// Getter method for Student's current Class
	public String getCurrentClass() {
		return currentClass;
	}

	// Setter method for Student's current Class
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}
	
	// Overrided toString method of Object class to get Student's data by its instance
	public String toString() {
		return "[Roll number:"+this.roll+", Name:"+this.name+", Year Of Joining:"+this.yearOfJoining+", DateOfBirth:"+this.dob+", Class"+this.currentClass+"]";
	}
}
