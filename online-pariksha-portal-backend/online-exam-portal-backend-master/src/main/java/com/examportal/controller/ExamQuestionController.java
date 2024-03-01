package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.AddQuestionDto;
import com.examportal.dto.QuestionsResponseDto;
import com.examportal.resource.ExamQuestionResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/exam/question")
@CrossOrigin(origins = "http://localhost:3000")
public class ExamQuestionController {
	
	@Autowired
	private ExamQuestionResource examQuestionResource;
	
	@PostMapping("/add")
	@Operation(summary = "Api to add exam question")
	public ResponseEntity<QuestionsResponseDto> addExamQuestion(@RequestBody AddQuestionDto request) {
		return examQuestionResource.addExamQuestion(request);
	}
	
	@DeleteMapping("/delete")
	@Operation(summary = "Api to delete exam question")
	public ResponseEntity<QuestionsResponseDto> deleteQuestion(@RequestParam("questionId") int questionId) {
		return examQuestionResource.deleteExamQuestion(questionId);
	}
	
	

}
