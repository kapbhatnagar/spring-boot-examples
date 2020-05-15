package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Address;
import com.boot.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Optional<List<Address>> getAllAddress() {
		Optional<List<Address>> addresss = null;
		addresss = Optional.ofNullable(addressRepository.findAll());
		return addresss;
	}

	@Override
	public Optional<Address> getAddress(String id) {
		return addressRepository.findById(id);
	}

	@Override
	public Optional<Address> addAddress(Address address) {
		return Optional.ofNullable(addressRepository.save(address));
	}

}
