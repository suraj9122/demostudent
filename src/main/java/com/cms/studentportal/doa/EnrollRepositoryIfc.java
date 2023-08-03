package com.cms.studentportal.doa;

import com.cms.studentportal.domain.Course;
import com.cms.studentportal.domain.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface EnrollRepositoryIfc extends JpaRepository<Enroll, Long> {

	List<Enroll> findByStudentId(@NotNull @NotEmpty Long studentId);

	Enroll findByStudentIdAndCourse(@NotNull @NotEmpty Long studentId,@NotNull Course course);
}
