package com.hospital.hospitaldemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitaldemo.model.Hospital;
import com.hospital.hospitaldemo.service.HospitalService;

@RestController
@RequestMapping(path = "/hospitals")
public class HospitalRestController {

	@Autowired
	HospitalService hospitalService;

	@RequestMapping(path = "/fetchDocName/{id}", produces = "application/json")
	public Map<Integer, String> getDoctorName(@PathVariable int id) {
		System.out.println("Fetching doctor name for id=" + id);
		Map<Integer, String> map = new HashMap<>();
		map.put(id, hospitalService.getNameOfDoctor(id));
		return map;
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<Hospital> addHospital(@Valid @RequestBody Hospital hospital) {
		hospitalService.saveHospital(hospital);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Hospital> getHospitals() {
		return hospitalService.getHospitals();
	}

}
