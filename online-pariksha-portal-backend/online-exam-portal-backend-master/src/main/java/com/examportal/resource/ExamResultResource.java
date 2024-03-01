package com.examportal.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.examportal.dto.ExamResultResponse;
import com.examportal.entity.Exam;
import com.examportal.entity.ExamResult;
import com.examportal.entity.Grade;
import com.examportal.entity.Question;
import com.examportal.entity.StudentAnswer;
import com.examportal.entity.User;
import com.examportal.service.ExamResultService;
import com.examportal.service.ExamService;
import com.examportal.service.GradeService;
import com.examportal.service.StudentAnswerService;
import com.examportal.service.UserService;

@Component
public class ExamResultResource {

	private final Logger LOG = LoggerFactory.getLogger(ExamResultResource.class);

	@Autowired
	private UserService userService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private ExamService examService;

	@Autowired
	private ExamResultService examResultService;

	@Autowired
	private StudentAnswerService studentAnswerService;

	public ResponseEntity<ExamResultResponse> fetchStudentExamResult(int studentId) {

		LOG.info("Request received for fetching result using student id");

		ExamResultResponse response = new ExamResultResponse();

		if (studentId == 0) {
			response.setResponseMessage("missing input");
			response.setSuccess(false);

			return new ResponseEntity<ExamResultResponse>(response, HttpStatus.BAD_REQUEST);
		}

		User student = this.userService.getUserById(studentId);

		List<ExamResult> results = this.examResultService.getResultsByStudent(student);

		if (CollectionUtils.isEmpty(results)) {
			response.setResponseMessage("No Exam Results found!!!");
			response.setSuccess(true);

			return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
		}

		for (ExamResult result : results) {

			if (!result.getExam().getQuestions().isEmpty()) {

				List<StudentAnswer> answers = this.studentAnswerService.getByExamAndStudent(result.getExam(), student);

				for (Question question : result.getExam().getQuestions()) {
					question.setCorrectAns(question.getCorrectAnswer());   // correctAnswer is json ignored, so it will go in response

					for (StudentAnswer answer : answers) {
						if (question.getId() == answer.getQuestion().getId()) {
							question.setAnswer(answer.getCorrectAnswer());
							break;
						}
					}

				}
			}

		}

		response.setResults(results);
		response.setResponseMessage("Exams Results Fetched successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<ExamResultResponse> fetchStudentExamResultGradeWise(int gradeId) {

		LOG.info("Request received for fetching result using grade id");

		ExamResultResponse response = new ExamResultResponse();

		if (gradeId == 0) {
			response.setResponseMessage("missing input");
			response.setSuccess(false);

			return new ResponseEntity<ExamResultResponse>(response, HttpStatus.BAD_REQUEST);
		}

		Grade grade = this.gradeService.getGradeById(gradeId);

		List<ExamResult> results = this.examResultService.getResultsByGrade(grade);

		if (CollectionUtils.isEmpty(results)) {
			response.setResponseMessage("No Exam Results found!!!");
			response.setSuccess(true);

			return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
		}

		for (ExamResult result : results) {

			if (!result.getExam().getQuestions().isEmpty()) {

				List<StudentAnswer> answers = this.studentAnswerService.getByExamAndStudent(result.getExam(), result.getStudent());

				for (Question question : result.getExam().getQuestions()) {
					question.setCorrectAns(question.getCorrectAnswer());   // correctAnswer is json ignored, so it will go in response

					for (StudentAnswer answer : answers) {
						if (question.getId() == answer.getQuestion().getId()) {
							question.setAnswer(answer.getCorrectAnswer());
							break;
						}
					}

				}
			}

		}

		response.setResults(results);
		response.setResponseMessage("Exams Results Fetched successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<ExamResultResponse> fetchAllStudentResults() {

		LOG.info("Request received for fetching results");

		ExamResultResponse response = new ExamResultResponse();
		
		List<ExamResult> results = this.examResultService.getAllResults();

		if (CollectionUtils.isEmpty(results)) {
			response.setResponseMessage("No Exam Results found!!!");
			response.setSuccess(true);

			return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
		}

		for (ExamResult result : results) {

			if (!result.getExam().getQuestions().isEmpty()) {

				List<StudentAnswer> answers = this.studentAnswerService.getByExamAndStudent(result.getExam(), result.getStudent());

				for (Question question : result.getExam().getQuestions()) {
					question.setCorrectAns(question.getCorrectAnswer());   // correctAnswer is json ignored, so it will go in response

					for (StudentAnswer answer : answers) {
						if (question.getId() == answer.getQuestion().getId()) {
							question.setAnswer(answer.getCorrectAnswer());
							break;
						}
					}

				}
			}

		}
		
		response.setResults(results);
		response.setResponseMessage("Exams Results Fetched successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<ExamResultResponse>(response, HttpStatus.OK);
	}

}
