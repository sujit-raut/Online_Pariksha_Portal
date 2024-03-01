package com.examportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entity.Grade;

@Repository
public interface GradeDao extends JpaRepository<Grade, Integer> {

	List<Grade> findByStatus(String status);
	
}
