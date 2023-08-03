package com.example.demo.controller;

import com.cms.studentportal.constant.Endpoint;
import com.cms.studentportal.constant.KeyConstant;
import com.cms.studentportal.domain.Enroll;
import com.cms.studentportal.exception.CourseNotFoundException;
import com.cms.studentportal.exception.UserAlreadyEnrollIntoCourseException;
import com.cms.studentportal.service.EnrollServiceIfc;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = Endpoint.ROOT_API_V1 + Endpoint.ENROLLMENT_URI)
public class EnrollmentController {

	private EnrollServiceIfc enrollServiceIfc;

	EnrollmentController(EnrollServiceIfc enrollServiceIfc) {
		this.enrollServiceIfc = enrollServiceIfc;
	}

	@GetMapping
	public @ResponseBody ResponseEntity<CollectionModel<Enroll>> getEnrollments() {

		List<Enroll> enrolCourses = enrollServiceIfc.getEnrolCourses();
		CollectionModel<Enroll> collectionModel = CollectionModel.of(enrolCourses);
		collectionModel.add(linkTo(methodOn(EnrollmentController.class).getEnrollments()).withSelfRel());

		return ResponseEntity.status(HttpStatus.OK).body(collectionModel);
	}

	@PostMapping
	public @ResponseBody ResponseEntity enrollIntoCourse(@RequestParam(KeyConstant.COURSE_ID) String courseId) throws CourseNotFoundException, UserAlreadyEnrollIntoCourseException {
		enrollServiceIfc.enrolIntoCourse(courseId);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
