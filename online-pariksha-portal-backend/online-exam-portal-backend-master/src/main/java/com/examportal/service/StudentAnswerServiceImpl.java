package com.examportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dao.StudentAnswerDao;
import com.examportal.entity.Exam;
import com.examportal.entity.Question;
import com.examportal.entity.StudentAnswer;
import com.examportal.entity.User;

@Service
public class StudentAnswerServiceImpl implements StudentAnswerService {

	@Autowired
	private StudentAnswerDao studentAnswerDao;

	@Override
	public StudentAnswer addAnswer(StudentAnswer answer) {
		// TODO Auto-generated method stub
		return studentAnswerDao.save(answer);
	}

	@Override
	public StudentAnswer getAnswer(int answerId) {
		Optional<StudentAnswer> optionalAnswer = studentAnswerDao.findById(answerId);

		if (optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}

	@Override
	public StudentAnswer getAnswerByQuestion(Question question) {
		return studentAnswerDao.findByQuestion(question);
	}

	@Override
	public List<StudentAnswer> getAllAnswerByExam(Exam exam) {
		// TODO Auto-generated method stub
		return studentAnswerDao.findByExam(exam);
	}

	@Override
	public List<StudentAnswer> addAnswers(List<StudentAnswer> answers) {
		// TODO Auto-generated method stub
		return studentAnswerDao.saveAll(answers);
	}

	@Override
	public List<StudentAnswer> getByExamAndStudent(Exam exam, User student) {
		return studentAnswerDao.findByExamAndStudent(exam, student);

	}

}
