package com.examportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dao.QuestionDao;
import com.examportal.entity.Question;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public Question addExamQuestion(Question question) {
		return questionDao.save(question);
	}

	@Override
	public Question getExamQuestionById(int questionId) {
		Optional<Question> optionalQuestion = questionDao.findById(questionId);

		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteQuestion(Question question) {
		questionDao.delete(question);
	}

}
