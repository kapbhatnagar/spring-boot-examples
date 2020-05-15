package com.boot.service;

import java.util.List;
import java.util.Optional;

import com.boot.model.Address;

public interface AddressService {

	Optional<List<Address>> getAllAddress();

	Optional<Address> getAddress(String id);

	Optional<Address> addAddress(Address address);
}
