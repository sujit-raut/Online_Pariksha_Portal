package com.examportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Exam;
import com.examportal.entity.Question;
import com.examportal.entity.StudentAnswer;
import com.examportal.entity.User;

@Repository
public interface StudentAnswerDao extends JpaRepository<StudentAnswer, Integer> {
	
	List<StudentAnswer> findByExam(Exam exam);
	
	StudentAnswer findByQuestion(Question question);
	
	List<StudentAnswer> findByExamAndStudent(Exam exam, User student);

}
