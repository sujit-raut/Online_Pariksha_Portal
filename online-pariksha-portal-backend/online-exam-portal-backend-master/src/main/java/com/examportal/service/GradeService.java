package com.examportal.service;

import java.util.List;

import com.examportal.entity.Grade;

public interface GradeService {

	Grade addGrade(Grade grade);

	Grade updateGrade(Grade grade);

	Grade getGradeById(int gradeId);

	List<Grade> getAllGradesByStatus(String status);

}
