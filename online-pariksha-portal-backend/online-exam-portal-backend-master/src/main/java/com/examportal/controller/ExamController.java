package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.AddExamRequest;
import com.examportal.dto.CommonApiResponse;
import com.examportal.dto.ExamResponseDto;
import com.examportal.resource.ExamResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/exam")
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {

	@Autowired
	private ExamResource exmaResource;

	@PostMapping("/add")
	@Operation(summary = "Api to add exam")
	public ResponseEntity<ExamResponseDto> addCourse(@RequestBody AddExamRequest request) {
		return exmaResource.addExam(request);
	}

	@GetMapping("/fetch/all")
	@Operation(summary = "Api to fetch all exams")
	public ResponseEntity<ExamResponseDto> fetchAllExams() {
		return exmaResource.fetchAllExams();
	}

	@GetMapping("/fetch/all/grade-wise")
	@Operation(summary = "Api to fetch all exams by grades")
	public ResponseEntity<ExamResponseDto> fetchAllExambyGrade(@RequestParam("gradeId") int gradeId) {
		return exmaResource.fetchAllExamByGrade(gradeId);
	}

	@GetMapping("/fetch/all/course-wise")
	@Operation(summary = "Api to fetch all exams by course")
	public ResponseEntity<ExamResponseDto> fetchAllExambyCourse(@RequestParam("courseId") int courseId) {
		return exmaResource.fetchAllExambyCourse(courseId);
	}

	@GetMapping("/fetch/exam-id")
	@Operation(summary = "Api to fetch Exam using ID")
	public ResponseEntity<ExamResponseDto> fetchExamById(@RequestParam("examId") int examId) {
		return exmaResource.fetchExamById(examId);
	}

	@DeleteMapping("/delete")
	@Operation(summary = "Api to delete exam")
	public ResponseEntity<CommonApiResponse> deleteExam(@RequestParam("examId") int examId) {
		return exmaResource.deleteExam(examId);
	}

	@GetMapping("/fetch/upcoming/grade-wise")
	@Operation(summary = "Api to fetch all upcoming exams by grade")
	public ResponseEntity<ExamResponseDto> fetchUpcomingExamsByGrade(@RequestParam("gradeId") int gradeId,
			@RequestParam("role") String role) {
		return exmaResource.fetchUpcomingExamsByGrade(gradeId, role);
	}

	@GetMapping("/fetch/previous/grade-wise")
	@Operation(summary = "Api to fetch all previous exams by grade")
	public ResponseEntity<ExamResponseDto> fetchPreviousExamsByGrade(@RequestParam("gradeId") int gradeId,
			@RequestParam("role") String role) {
		return exmaResource.fetchPreviousExamsByGrade(gradeId, role);
	}

	@GetMapping("/fetch/grade-wise/ongoing")
	@Operation(summary = "Api to fetch all ongoing exams by grade")
	public ResponseEntity<ExamResponseDto> fetchOngoingExamsByGrade(@RequestParam("gradeId") int gradeId,
			@RequestParam("studentId") int studentId, @RequestParam("role") String role) {
		return exmaResource.fetchOngoingExamsByGrade(gradeId, studentId, role);
	}

}
