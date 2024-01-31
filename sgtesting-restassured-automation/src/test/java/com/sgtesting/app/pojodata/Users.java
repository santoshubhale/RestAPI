package com.sgtesting.app.pojodata;

public class Users {
	
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	private String phoneNumber;
	private String stateName;
	private String userRole;
	private int zipcode;
	
	
	public Users() {
		super();
	}

	public Users(String stateName)
	{
		this.stateName=stateName;
	}

	public Users(String firstName, String lastName, String address, String emailId, String phoneNumber,
			String stateName, String userRole, int zipcode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.stateName = stateName;
		this.userRole = userRole;
		this.zipcode = zipcode;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", stateName=" + stateName + ", userRole=" + userRole
				+ ", zipcode=" + zipcode + "]";
	}

}
