package com.cg.vehicle.vehi;

import java.sql.Date;

public class Customer {
	private String name;
	private String CustId;
	private String address;
	private String phoneNumber;
	private Date dateOfBooking;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String custId) {
		CustId = custId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	@Override
	public String toString() {
		return "VehicleInfo [name=" + name + ", CustId=" + CustId + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", dateOfBooking=" + dateOfBooking + "]";
	}
}
