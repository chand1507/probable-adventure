package com.cg.vehicle.vehi.pl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.cg.vehicle.vehi.Customer;
import com.cg.vehicle.vehi.customerservice.ICustomerService;
import com.cg.vehicle.vehi.customerservice.CustomerServiceImpl;
import com.cg.vehicle.vehi.exception.VehicleException;
import com.cg.vehicle.vehi.util.DBConnection;

public class VehicleMain {
	static Scanner in = new Scanner(System.in);
	static CustomerServiceImpl customerServiceImpl = null;
	static ICustomerService customerService = null;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Customer custInfo = null;
		VehicleException vehicleException = null;
		String custId = null;
		int option = 0;
		int option2 = 0;
		while (true) {
			System.out.println("Welcome to ESC Vehicles");
			System.out.println("----------------------------\n");
			System.out.println(" 1.Add Customer");
			System.out.println(" 2.View vehicles ");
			System.out.println(" 3.Exit");
			System.out.println(" ------------------");
			System.out.println("select an option :");
			try {
				option = in.nextInt();
				switch (option) {

				case 1:
					while (custInfo == null) {
						custInfo = addCustomer();
					}

					try {
						customerService = new CustomerServiceImpl();
						custId = customerService.addCustomer(custInfo);
						System.out.println("Details has been added successfully");
						System.out.println("Customer Id: " + custId);

					} finally {
						custId = null;
						customerService = null;
						custInfo = null;
					}
					break;
					case 2: 
						System.out.println("Enter your choice of vehicle in the given list");
						System.out.println("1.Car");
						System.out.println("2.Bike");
						option2 = in.nextInt();
						
						switch(option2)
						{
						case 1:
							
							System.out.println("car");
							
							
							Connection con = DBConnection.getConnection();
							System.out.println("1");
							Statement st = null;
							PreparedStatement pst = null;
							ResultSet rs = null;
							st=con.createStatement();
							System.out.println("2");
							pst.executeQuery("SELECT * FROM car");
							System.out.println("3");
							
							pst.executeUpdate();
							while (rs.next()) {
								custId = rs.getString(1);
								System.out.println(rs.getString(2));
								
								rs.getString(3);
								rs.getString(3);
								break;
							}
							break;
						case 2:
							System.out.println("Bike");
							break;
						}
						

						break;
							
					/*
					 * case2:
					 * 
					 * //System.out.println("Enter your choice of vehicle in the given list");
					 * option2=in.nextInt();
					 * 
					 * switch (option2) {
					 * 
					 * }
					 * 
					 * break;
					 */
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} // ends while
	} // ends main

	private static Customer addCustomer() throws Exception {
		Customer custInfo = new Customer();
		System.out.println("\nEnter Details: ");

		System.out.print("\nEnter name: ");
		custInfo.setName(in.next());

		System.out.print("Enter Address: ");
		custInfo.setAddress(in.next());

		System.out.print("Enter Phonenumber: ");
		custInfo.setPhoneNumber(in.next());

		customerServiceImpl = new CustomerServiceImpl();

		try {

			CustomerServiceImpl.validateCustomer(custInfo);

			return custInfo;

		} catch (VehicleException ve) {
			System.err.println("Invalid data: ");
			System.err.println(ve.getMessage() + "\n try again  ");
			System.exit(0);
		}
		return null;
	}
}