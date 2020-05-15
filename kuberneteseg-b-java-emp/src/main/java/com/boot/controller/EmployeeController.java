package com.boot.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.client.AddressWebClient;
import com.boot.model.Address;
import com.boot.model.Employee;
import com.boot.service.EmployeeService;
import com.boot.vo.EmployeeVO;

@Controller
// @RequestMapping("/employee-details")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AddressWebClient addressWebClient;
	
	@GetMapping("/test")
	public String testMethod(Model model) {
		logger.info("----- test --------");
		//addressWebClient.getAllAddress();
		
		Address a= addressWebClient.getAddressWithUodatedTimeout("5ea9303ad248012e60113d86");
		logger.info(a.toString());
		
		model.addAttribute("employeeVO", new EmployeeVO());
		return "empModifyPage";
	}

	@RequestMapping("/list-emp")
	public String renderPage(Map<String, Object> model) {
		model.put("employeeList", employeeService.getEmployeeList());
		logger.info("Rendering page.");
		return "home";
	}

	@GetMapping("/add")
	public String displayAddEmplPage(Model model) {
		model.addAttribute("employeeVO", new EmployeeVO());
		return "empModifyPage";
	}

	@PostMapping("/add")
	public String addEmployee(ModelMap model, @Valid EmployeeVO employeeVO, BindingResult result) {
		if (result.hasErrors()) {
			return "empModifyPage";
		}
		logger.info("Adding Employee whose name is: " + employeeVO.getName());
		employeeService.addEmployee(employeeVO);

		return "redirect:/list-emp";
	}

}
