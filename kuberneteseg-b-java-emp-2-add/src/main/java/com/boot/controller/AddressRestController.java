package com.boot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Address;
import com.boot.repository.AddressRepository;
import com.boot.service.AddressService;


@RestController
@RequestMapping("/api")
public class AddressRestController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddresss() {
		System.out.println("Fethcing all address");
		Optional<List<Address>> addresss = addressService.getAllAddress();
		try {
			if (addresss.isPresent() && !addresss.get().isEmpty()) {
				return new ResponseEntity<>(addresss.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddresss(@PathVariable String id) {
		System.out.println("Fethcing tutorial for id= " + id);
		Optional<Address> address = addressService.getAddress(id);
		if (address.isPresent()) {
			return new ResponseEntity<>(address.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/address")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address addressFrmRequest) {
		System.out.println("Adding address whose zipcode= " + addressFrmRequest.getZipCode());
		Optional<Address> address = addressService.addAddress(addressFrmRequest);
		try {
			if (address.isPresent()) {
				return new ResponseEntity<>(address.get(), HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

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
