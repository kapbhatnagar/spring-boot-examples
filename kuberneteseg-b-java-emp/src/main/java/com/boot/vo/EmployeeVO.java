package com.boot.vo;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class EmployeeVO {

	private String name;

	private BigInteger salary;

	private String addressId;

	private String addressLine1;
	private String addressLine2;
	private String zipCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getSalary() {
		return salary;
	}

	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "EmployeeVO [name=" + name + ", salary=" + salary + ", addressId=" + addressId + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", zipCode=" + zipCode + "]";
	}

}
