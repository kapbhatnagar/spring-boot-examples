package com.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.boot.model.Address;

@RepositoryRestResource(path = "addresses", collectionResourceRel = "addresses")
public interface AddressRepository extends MongoRepository<Address, String> {

	// http://localhost:8080/notes
	// Sort http://localhost:8080/notes?sort=zipCode
}
