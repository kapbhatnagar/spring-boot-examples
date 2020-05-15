package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Employee;
import com.boot.model.EmployeeRepository;
import com.boot.vo.EmployeeVO;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {

		return employeeRepository.findAll();
	}

	public void addEmployee(EmployeeVO employeeVO) {
		Employee employee = new Employee();
		employee.setName(employeeVO.getName());
		employee.setSalary(employeeVO.getSalary());
		employeeRepository.save(employee);
		
		//Save data to Address
	}

}
