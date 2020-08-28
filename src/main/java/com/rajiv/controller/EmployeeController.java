package com.rajiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajiv.model.Employee;
import com.rajiv.services.EmployeeService;

@RestController
public class EmployeeController {
	
@Autowired	
private EmployeeService employeeService;
	
//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormforUpdate(@PathVariable ( value = "id") long id, Model model){
		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}

}
