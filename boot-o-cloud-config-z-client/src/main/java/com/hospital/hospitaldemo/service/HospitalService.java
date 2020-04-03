package com.hospital.hospitaldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitaldemo.model.Hospital;
import com.hospital.hospitaldemo.model.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	public String getNameOfDoctor(int id) {
		return "Sachin Tendulkar";
	}
	
	public void saveHospital(Hospital hospital){
		hospitalRepository.save(hospital);
	}
	
	public List<Hospital> getHospitals(){
		return hospitalRepository.findAll();
	}
}
