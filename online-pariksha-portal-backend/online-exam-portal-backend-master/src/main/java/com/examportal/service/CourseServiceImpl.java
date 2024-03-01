package com.examportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dao.CourseDao;
import com.examportal.entity.Course;
import com.examportal.entity.Grade;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	@Override
	public Course getCourseById(int courseId) {
		Optional<Course> optionalCourse = courseDao.findById(courseId);

		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Course> getAllCoursesByStatus(String status) {
		// TODO Auto-generated method stub
		return courseDao.findByStatus(status);
	}

	@Override
	public List<Course> getAllCoursesByGradeAndStatus(Grade grade, String status) {
		// TODO Auto-generated method stub
		return courseDao.findByGradeAndStatus(grade, status);
	}

}
