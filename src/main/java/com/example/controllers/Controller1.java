package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeRepository;
import com.example.model.Employee;
import com.example.services.EmployeeServices;

@RestController
public class Controller1 {
	
	
@Autowired	
public	EmployeeServices employeeServices;
	
	
	// add the employee
	
	@PostMapping("/user/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		
	System.out.println(employee);
	
	
	System.out.println("data received ...");
	
	if(employee.getName().isEmpty())
	{
		return ResponseEntity.ok("name is empty.....");
	}
	
	Employee employeeSer = employeeServices.addEmployeeSer(employee);
	System.out.println("addedd..");
	
	return new  ResponseEntity<>(employeeSer,HttpStatus.OK);	
	}
	
	
	

	
	
	//getting the employee by id
	
	@GetMapping("/user/get/{id}")
	public ResponseEntity<?>  getEmployeeByIdCon(@PathVariable("id") Integer id) {
	
		  // Validate the ID (ensure it's not null or invalid)
	    if (id == null || id.intValue() <= 0) {
	        return new ResponseEntity<>("Invalid employee ID provided!", HttpStatus.BAD_REQUEST);
	        // 400 Bad Request
	    }
	Employee employee12 = employeeServices.getEmployeeSer(id);
		
	
	   // Check if the employee exists
    if (employee12 == null) {
        return new ResponseEntity<>("Employee not found with ID: " + id, HttpStatus.NOT_FOUND); // 404 Not Found
    }
	
 return  new 	ResponseEntity<>(employee12,HttpStatus.OK);
 
 
	}
	
	
	
	
	
	
	// deleting the employee by id 
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteByIdCon(@PathVariable("id") Integer id)
	
	{
		
	employeeServices.deleteEmployeeSer(id);
		
	return ResponseEntity.ok("employee deleted success....");	
	}
	
	
	
	// getting the list of all employee
	
	@GetMapping("/user/get/all")
	public ArrayList<Employee> getAllEmployee()
	{
		
		return employeeServices.getAllEmployeeSer();
	}
	
	
	
	// search for the id 
	
	@GetMapping("/user/search/{id}")
	public Boolean searchIdCon(@PathVariable Integer id)
	{
		
		boolean searchByIdSer = employeeServices.searchByIdSer(id);
		if(searchByIdSer==true)
		{
			return true;
		}
		
		return false;
		
	}
	
	
	
	// search the employee by name
	
	
	@GetMapping("/user/searchname/{name}")
	public List<Employee> findByNameCon(@PathVariable String name)
	{
		
		List<Employee> byNameser = employeeServices.findByNameser(name);
		return byNameser;
	}
	
	// getting the record of the employee using the page by pagination
	@GetMapping("/user/getbypage")
	public Page<Employee> getAllEmployeeByPageCon(@RequestParam Integer pagenumber,@RequestParam Integer pagesize , @RequestParam String name)
	
	{
		
	
		System.out.println("page number is ="+pagenumber+" pagesize is ="+pagesize);
		
		 Page<Employee> allByPageSer = employeeServices.getAllByPageSer(pagenumber, pagesize,name);
		 
		return allByPageSer;
		
		
	}
	
	
	
}
