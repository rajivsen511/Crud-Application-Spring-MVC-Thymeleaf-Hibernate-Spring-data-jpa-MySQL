package com.rajiv.services;

import java.util.List;

import com.rajiv.model.Employee;



public interface EmployeeService{
	

 List<Employee> getAllEmployees();
 void saveEmployee(Employee employee);
 Employee getEmployeeById(long id);
 void deleteEmployeeById(long Id);

}
