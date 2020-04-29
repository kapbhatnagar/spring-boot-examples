package com.boot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.model.Employee;
import com.boot.service.EmployeeService;

@Controller
@RequestMapping("/employee-details")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("")
	public String renderPage(Map<String, Object> model) {
		model.put("employeeList", employeeService.getEmployeeList());
		logger.info("Rendering page.");
		return "home";
	}

	@GetMapping("/add")
	public String displayAddEmplPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmpPage";
	}

	@PostMapping("/add")
	public String greetingSubmit(@ModelAttribute Employee employee) {
		logger.info("Employee to insert= " + employee.toString());
		return "home";
	}

}
