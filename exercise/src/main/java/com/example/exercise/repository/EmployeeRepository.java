package com.example.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.exercise.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{ 
	@Query("SELECT e FROM Employee e ORDER BY e.id ASC") 
	List<Employee> findTopN(int limit); 
}
