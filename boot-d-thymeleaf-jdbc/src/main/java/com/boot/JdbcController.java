package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {
	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/insert")
	public String index() {
		jdbc.execute("insert into jdbc_exapmle(name,email)values('javatpoint','java@javatpoint.com')");
		return "data inserted Successfully";
	}
}