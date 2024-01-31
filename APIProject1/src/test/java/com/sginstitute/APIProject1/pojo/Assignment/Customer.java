package com.sginstitute.APIProject1.pojo.Assignment;

public class Customer {
	private String address;
	private String emailId;
	private String customerName;
	private String location;
	private String phoneNumber;
	public Customer(String address, String emailId, String customerName, String location, String phoneNumber) {
		super();
		this.address = address;
		this.emailId = emailId;
		this.customerName = customerName;
		this.location = location;
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
