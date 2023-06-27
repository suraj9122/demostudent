package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Course {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String course;
	
	
	
	@ManyToMany
	private List<UserDetails> user=new ArrayList<>();
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public List<UserDetails> getUser() {
		return user;
	}
	public void setUser(List<UserDetails> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", course=" + course + "]";
	}
	

}
