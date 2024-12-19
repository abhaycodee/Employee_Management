package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
	

	// this method return 1 if found and null if not found ...
	@Query(value = "SELECT 1 FROM employee_table WHERE eid = :id LIMIT 1", nativeQuery = true)
	public Integer searchId(Integer id);

	
	// this method find the employee with given name
	
	public List<Employee> findByNameContaining(String name);
	
	
	
	
}
