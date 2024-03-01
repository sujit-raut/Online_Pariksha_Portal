package com.examportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dao.ExamResultDao;
import com.examportal.entity.Exam;
import com.examportal.entity.ExamResult;
import com.examportal.entity.Grade;
import com.examportal.entity.User;

@Service
public class ExamResultServiceImpl implements ExamResultService {
	
	@Autowired
	private ExamResultDao examResultDao;

	@Override
	public ExamResult addResult(ExamResult result) {
		// TODO Auto-generated method stub
		return examResultDao.save(result);
	}

	@Override
	public List<ExamResult> getResultsByStudent(User student) {
		return examResultDao.findByStudent(student);
	}

	@Override
	public List<ExamResult> getResultsByStudentAndExam(User student, Exam exam) {
		// TODO Auto-generated method stub
		return examResultDao.findByStudentAndExam(student, exam);
	}

	@Override
	public List<ExamResult> getResultsByExam(Exam exam) {
		// TODO Auto-generated method stub
		return examResultDao.findByExam(exam);
	}

	@Override
	public ExamResult getExamResultById(int resultId) {
		Optional<ExamResult> optionalExamResult = examResultDao.findById(resultId);

		if (optionalExamResult.isPresent()) {
			return optionalExamResult.get();
		} else {
			return null;
		}
	}

	@Override
	public List<ExamResult> getResultsByGrade(Grade grade) {
		// TODO Auto-generated method stub
		return this.examResultDao.findByExam_Grade(grade);
	}

	@Override
	public List<ExamResult> getAllResults() {
		// TODO Auto-generated method stub
		return this.examResultDao.findAll();
	}

}
