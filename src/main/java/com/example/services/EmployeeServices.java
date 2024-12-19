package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.model.Employee;

@Service
public class EmployeeServices {
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// adding the employee to db
	
	public Employee addEmployeeSer(Employee employee)
	{
		
		
		Employee employee2 = employeeRepository.save(employee);
		
		return employee2;
		
		
	}
	
	// getting the employee from db
		
	public Employee getEmployeeSer(Integer id)
	{
		
		
		Employee orElse = employeeRepository.findById(id).orElse(null);
		
		 return orElse;
		
	}
	
	// deleting the employee from db using id
	
	public void deleteEmployeeSer(Integer id)
	{
		
		employeeRepository.deleteById(id);
		System.out.println("delete success..");
	}
	
	
	// getting all the employee
	
	public ArrayList<Employee> getAllEmployeeSer()
	{
		
		
		 ArrayList<Employee> all = (ArrayList<Employee>) employeeRepository.findAll();
		 return all;
		
		
	}
	
	//search by is 
	
	
	
	public Boolean searchByIdSer(Integer id)
	{
		Integer searchId = employeeRepository.searchId(id);
		if(searchId!=null&&searchId>0) {
			return true;
		}
		return false;
	}

	
	
	// search the employee by name
	
	
	public List<Employee> findByNameser (String name)
	{
		
		List<Employee> byNameContaining = employeeRepository.findByNameContaining(name);
		return byNameContaining;
		
	}
	
	
	// getting all the employee pageably
	
	
	public Page<Employee> getAllByPageSer(Integer pagenumber,Integer pagesize)
	{
		
		Integer pagenumber1=pagenumber;
		Integer pagesize1=pagesize;
		
		PageRequest p = PageRequest.of(pagenumber1, pagesize1);
		Page<Employee> all = employeeRepository.findAll(p);
	
		
		return all;
	
		
	}
	
	
	
	
	
}
