package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity
public class UserDetails {
	@Id
	private int id;
	private String name;
	private String address;
	private String contact;
	private String password;	
	private String email;
	private String courseid;
	
	
	@ManyToMany(mappedBy="user",cascade=CascadeType.ALL)
	
	private List<Course> course=new ArrayList<>();
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", password=" + password + ", email=" + email + ", courseid=" + courseid + "]";
	}
	public UserDetails orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
