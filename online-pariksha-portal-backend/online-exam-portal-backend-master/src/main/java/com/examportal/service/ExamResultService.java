package com.examportal.service;

import java.util.List;

import com.examportal.entity.Exam;
import com.examportal.entity.ExamResult;
import com.examportal.entity.Grade;
import com.examportal.entity.User;

public interface ExamResultService {
	
	ExamResult addResult(ExamResult result);
	
	ExamResult getExamResultById(int resultId);
	
	List<ExamResult> getResultsByStudent(User student);
	
	List<ExamResult> getResultsByStudentAndExam(User student, Exam exam);
	
	List<ExamResult> getResultsByExam(Exam exam);
	
	List<ExamResult> getResultsByGrade(Grade grade);
	
	List<ExamResult> getAllResults();

}
