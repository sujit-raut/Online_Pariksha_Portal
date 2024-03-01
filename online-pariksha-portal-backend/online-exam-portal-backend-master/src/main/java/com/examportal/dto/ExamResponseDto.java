package com.examportal.dto;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.Exam;


public class ExamResponseDto extends CommonApiResponse {
	
	private List<Exam> exams = new ArrayList<>();

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

}
