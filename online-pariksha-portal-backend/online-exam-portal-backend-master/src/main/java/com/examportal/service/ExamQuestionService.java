package com.examportal.service;

import com.examportal.entity.Question;

public interface ExamQuestionService {
	
	Question addExamQuestion(Question question);
	
	Question getExamQuestionById(int questionId);
	
	void deleteQuestion(Question question);

}
