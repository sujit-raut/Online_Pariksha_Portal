package com.examportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Course;
import com.examportal.entity.Grade;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
	
	List<Course> findByGradeAndStatus(Grade grade, String status);
	
	List<Course> findByStatus(String status);											

}
