package com.example.demo.doa;

import com.cms.studentportal.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CourseRepositoryIfc extends JpaRepository<Course, Long> {

	@Query("FROM Course WHERE title LIKE %:title%")
	@Modifying
	List<Course> searchByTitleKeyword(@NotNull @NotEmpty String title);

	Course findByCourseId(@NotNull @NotEmpty String courseId);
}
