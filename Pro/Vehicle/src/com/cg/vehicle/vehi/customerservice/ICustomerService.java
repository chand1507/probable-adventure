package com.cg.vehicle.vehi.customerservice;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.vehicle.vehi.Customer;

public interface ICustomerService {
	public String addCustomer(Customer cust) throws ClassNotFoundException, SQLException, IOException;
	public String ViewCar();
	public String ViewBike();

}
