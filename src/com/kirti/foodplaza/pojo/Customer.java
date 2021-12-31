package com.kirti.foodplaza.pojo;

public class Customer {

	private int custId;
	
	private String custEmail;
	
	private String custPassword;
	
	private Long contactNumber;
	
	private String address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custEmail, String custPassword, Long contactNumber, String address) {
		super();
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Customer(int custId, String custEmail, String custPassword, Long contactNumber, String address) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
