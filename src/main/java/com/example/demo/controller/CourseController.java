package com.example.demo.controller;

import com.example.constant.Endpoint;
import com.example.domain.Course;
import com.cms.studentportal.exception.CourseNotFoundException;
import com.cms.studentportal.exception.UserAlreadyEnrollIntoCourseException;
import com.cms.studentportal.service.CourseServiceIfc;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = Endpoint.ROOT_API_V1)
public class CourseController {

	private CourseServiceIfc courseServiceIfc;

	CourseController(CourseServiceIfc courseServiceIfc) {
		this.courseServiceIfc = courseServiceIfc;
	}

	@GetMapping(value = Endpoint.VIEW_COURSE_URI)
	public @ResponseBody ResponseEntity<CollectionModel<Course>> getCourses() throws CourseNotFoundException, UserAlreadyEnrollIntoCourseException {
		List<Course> courseList = this.courseServiceIfc.findAllCourse();

		for (Course course : courseList) {
			course.add(linkTo(methodOn(EnrollmentController.class).enrollIntoCourse(course.getCourseId()))
					.withRel("enroll_into_course"));
		}

		CollectionModel<Course> collectionModel = CollectionModel.of(courseList);
		collectionModel.add(linkTo(methodOn(CourseController.class).getCourses()).withSelfRel());
		collectionModel.add(linkTo(methodOn(CourseController.class).searchCourses("search_keyword_here")).withRel("search"));
		return ResponseEntity.status(HttpStatus.OK).body(collectionModel);
	}

	@GetMapping(value = Endpoint.SEARCH_COURSE_URI)
	public @ResponseBody ResponseEntity<CollectionModel<Course>> searchCourses(@RequestParam String title) throws CourseNotFoundException, UserAlreadyEnrollIntoCourseException {
		List<Course> courseList = this.courseServiceIfc.searchCourses(title);

		for (Course course : courseList) {
			course.add(linkTo(methodOn(EnrollmentController.class).enrollIntoCourse(course.getCourseId()))
					.withRel("enroll_into_course"));
		}

		CollectionModel<Course> collectionModel = CollectionModel.of(courseList);
		collectionModel.add(linkTo(methodOn(CourseController.class).searchCourses(title)).withSelfRel());
		collectionModel
				.add(linkTo(methodOn(CourseController.class).getCourses()).withRel(IanaLinkRelations.COLLECTION));
		return ResponseEntity.status(HttpStatus.OK).body(collectionModel);
	}

}
