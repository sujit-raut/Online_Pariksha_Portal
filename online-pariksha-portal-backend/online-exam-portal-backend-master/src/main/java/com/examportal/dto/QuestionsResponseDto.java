package com.examportal.dto;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.Question;

public class QuestionsResponseDto extends CommonApiResponse {

	private List<Question> questions = new ArrayList<>();

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
