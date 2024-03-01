package com.examportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Course;
import com.examportal.entity.Exam;
import com.examportal.entity.Grade;
import com.examportal.entity.User;

@Repository
public interface ExamDao extends JpaRepository<Exam, Integer> {

	List<Exam> findByCourseAndStatus(Course course, String status);

	List<Exam> findByGradeAndStatus(Grade grade, String status);

	List<Exam> findByTeacherAndStatus(User teacher, String status);

	List<Exam> findByStatus(String status);

	List<Exam> findByGradeAndStartTimeGreaterThanAndStatus(Grade grade, String startTime, String status);

	List<Exam> findByGradeAndStartTimeLessThanAndStatus(Grade grade, String startTime, String status);

	List<Exam> findByGradeAndStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndStatus(Grade grade, String currentTime,
			String currenTime, String status);

}
