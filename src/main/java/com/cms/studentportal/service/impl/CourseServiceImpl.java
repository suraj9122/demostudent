package com.cms.studentportal.service.impl;

import com.cms.studentportal.doa.CourseRepositoryIfc;
import com.cms.studentportal.domain.Course;
import com.cms.studentportal.service.CourseServiceIfc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceIfc {

	private CourseRepositoryIfc courseRepositoryIfc;

	CourseServiceImpl(CourseRepositoryIfc courseRepositoryIfc) {
		this.courseRepositoryIfc = courseRepositoryIfc;
	}

	@Override
	public void createCourse(Course course) {
		courseRepositoryIfc.save(course);
	}

	@Override
	public List<Course> findAllCourse() {
		return courseRepositoryIfc.findAll();
	}

	@Override
	public List<Course> searchCourses(String name) {
		return courseRepositoryIfc.searchByTitleKeyword(name);
	}

}
