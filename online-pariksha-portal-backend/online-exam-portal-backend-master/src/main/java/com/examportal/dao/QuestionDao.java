package com.examportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
}
