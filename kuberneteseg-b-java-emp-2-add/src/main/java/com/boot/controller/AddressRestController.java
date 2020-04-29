package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Address;
import com.boot.repository.AddressRepository;


@RestController
@RequestMapping("/api")
public class AddressRestController {
	
	@Autowired
	AddressRepository addressRepository;

	@RequestMapping(path = "/name", method = RequestMethod.GET)
	public List<Address> getAll() {
		System.out.println("Fetching all address");
		List<Address> addressList = addressRepository.findAll();
		System.out.println("-------------------");
		return addressList;
	}
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String getTest() {
		return "rest services are up.";
	}
}
