package com.examportal.service;

import java.util.List;

import com.examportal.entity.Exam;
import com.examportal.entity.Question;
import com.examportal.entity.StudentAnswer;
import com.examportal.entity.User;

public interface StudentAnswerService {
	
	StudentAnswer addAnswer(StudentAnswer answer);
	
	StudentAnswer getAnswer(int answerId);
	
	StudentAnswer getAnswerByQuestion(Question question);
	
	List<StudentAnswer> getAllAnswerByExam(Exam exam);
	
	List<StudentAnswer> addAnswers(List<StudentAnswer> answers);
	
	List<StudentAnswer> getByExamAndStudent(Exam exam, User student);


}
