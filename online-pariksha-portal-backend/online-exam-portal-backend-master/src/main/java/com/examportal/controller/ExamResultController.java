package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.ExamResultResponse;
import com.examportal.resource.ExamResultResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/exam/result")
@CrossOrigin(origins = "http://localhost:3000")
public class ExamResultController {
	
	@Autowired
	private ExamResultResource examResultResource;
	
	@GetMapping("/fetch/student-wise")
	@Operation(summary = "Api to fetch student exam student")
	public ResponseEntity<ExamResultResponse> fetchStudentExamResult(@RequestParam("studentId") int studentId) {
		return examResultResource.fetchStudentExamResult(studentId);
	}
	
	@GetMapping("/fetch/grade-wise")
	@Operation(summary = "Api to fetch student exam results by grade id")
	public ResponseEntity<ExamResultResponse> fetchStudentExamResultGradeWise(@RequestParam("gradeId") int gradeId) {
		return examResultResource.fetchStudentExamResultGradeWise(gradeId);
	}
	
	@GetMapping("/fetch/all")
	@Operation(summary = "Api to fetch student exam results")
	public ResponseEntity<ExamResultResponse> fetchAllStudentResults() {
		return examResultResource.fetchAllStudentResults();
	}

}
