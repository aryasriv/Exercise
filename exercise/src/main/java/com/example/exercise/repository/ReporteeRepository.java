package com.example.exercise.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise.entity.Reportee;

public interface ReporteeRepository extends JpaRepository<Reportee, Long> 
{ 
	@Query("SELECT r FROM Reportee r ORDER BY r.id ASC") 
	List<Reportee> findTopN(int limit); 
}
