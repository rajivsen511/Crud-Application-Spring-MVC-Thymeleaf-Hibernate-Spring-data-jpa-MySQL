package com.rajiv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajiv.model.Employee;
import com.rajiv.repository.EmployeeRepository;
@Service

public class EmployeeServiceImpl implements EmployeeService{
@Autowired
private EmployeeRepository employeeRepository;
	
@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
