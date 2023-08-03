package com.example.demo.exception;

public class CourseNotFoundException extends Exception{

	public CourseNotFoundException(String courseId){
		super("Course does not exist "+courseId);
	}
}
