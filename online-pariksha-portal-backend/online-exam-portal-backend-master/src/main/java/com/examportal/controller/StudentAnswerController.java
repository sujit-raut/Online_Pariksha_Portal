package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.AddQuestionDto;
import com.examportal.dto.QuestionsResponseDto;
import com.examportal.dto.StudentAnswerRequest;
import com.examportal.resource.StudentAnswerResourse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/student/answer")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAnswerController {
	
	@Autowired
	private StudentAnswerResourse studentAnswerResourse;
	
	@PostMapping("/add")
	@Operation(summary = "Api to add student answers")
	public ResponseEntity<QuestionsResponseDto> addExamQuestion(@RequestBody StudentAnswerRequest request) {
		return studentAnswerResourse.addStudentAnswers(request);
	}

}
