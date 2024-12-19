package com.example.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Employee {
	
	
	
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int eid;
private String name;
private String address;
private int salary;
	
private String department;

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public Employee(int eid, String name, String address, int salary, String department) {
	super();
	this.eid = eid;
	this.name = name;
	this.address = address;
	this.salary = salary;
	this.department = department;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", salary=" + salary + ", department="
			+ department + "]";
}	








}
