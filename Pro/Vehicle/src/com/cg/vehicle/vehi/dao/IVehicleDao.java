package com.cg.vehicle.vehi.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.vehicle.vehi.Customer;

public interface IVehicleDao {
	public String addCustomer(Customer db) throws ClassNotFoundException, SQLException, IOException;
	public String ViewCar();
	public String ViewBike();
	
}
