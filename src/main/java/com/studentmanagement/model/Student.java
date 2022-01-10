package com.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "student")
@XmlRootElement
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String major;
	
	public Student() {}
	
	public Student(String firstName, String lastName, int age, String major) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.major = major;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
