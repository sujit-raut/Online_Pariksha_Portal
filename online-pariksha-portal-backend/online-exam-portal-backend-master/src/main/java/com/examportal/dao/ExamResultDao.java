package com.examportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Exam;
import com.examportal.entity.ExamResult;
import com.examportal.entity.Grade;
import com.examportal.entity.User;

@Repository
public interface ExamResultDao extends JpaRepository<ExamResult, Integer> {

	List<ExamResult> findByExam(Exam exam);

	List<ExamResult> findByStudent(User student);

	List<ExamResult> findByStudentAndExam(User student, Exam exam);

	List<ExamResult> findByExam_Grade(Grade grade);

}
