package com.rajiv.services;

import java.util.List;
import java.util.Optional;

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

@Override
public void saveEmployee(Employee employee) {
this.employeeRepository.save(employee);
	
}

public Employee getEmployeeById(long id) {
	Optional<Employee> optional = employeeRepository.findById(id);
	Employee employee = null;
	if(optional.isPresent()) {
		employee = optional.get();
	}
	else
	{throw new RuntimeException("Employee not found for id ::"+id);
	}
	return employee;
}

}
