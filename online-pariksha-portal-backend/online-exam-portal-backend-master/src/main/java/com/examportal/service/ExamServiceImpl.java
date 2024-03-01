package com.examportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examportal.dao.ExamDao;
import com.examportal.entity.Course;
import com.examportal.entity.Exam;
import com.examportal.entity.Grade;
import com.examportal.entity.User;

@Repository
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;

	@Override
	public Exam addExam(Exam exam) {
		// TODO Auto-generated method stub
		return this.examDao.save(exam);
	}

	@Override
	public Exam updateExam(Exam exam) {
		// TODO Auto-generated method stub
		return this.examDao.save(exam);
	}

	@Override
	public Exam getExamById(int examId) {
		Optional<Exam> optionalExam = examDao.findById(examId);

		if (optionalExam.isPresent()) {
			return optionalExam.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Exam> getAllExamsByStatus(String status) {
		return this.examDao.findByStatus(status);
	}

	@Override
	public List<Exam> getAllExamsByGradeAndStatus(Grade grade, String status) {
		return this.examDao.findByGradeAndStatus(grade, status);
	}

	@Override
	public List<Exam> getAllExamsByCourseAndStatus(Course course, String status) {
		return this.examDao.findByCourseAndStatus(course, status);
	}

	@Override
	public List<Exam> getAllExamsByTeacherAndStatus(User teacher, String status) {
		return this.examDao.findByTeacherAndStatus(teacher, status);
	}

	public List<Exam> getExamsByGradeAndStartTimeGreaterThanAndStatus(Grade grade, String startTime, String status) {
		return this.examDao.findByGradeAndStartTimeGreaterThanAndStatus(grade, startTime, status);

	}

	@Override
	public List<Exam> getExamsByGradeAndStartTimeLessThanAndStatus(Grade grade, String startTime, String status) {
		// TODO Auto-generated method stub
		return this.examDao.findByGradeAndStartTimeLessThanAndStatus(grade, startTime, status);
	}

	@Override
	public List<Exam> getExamsByGradeAndStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndStatus(Grade grade,
			String currentTime, String currenTime, String status) {

		return this.examDao.findByGradeAndStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndStatus(grade, currentTime,
				currenTime, status);
	}

}
