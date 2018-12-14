package com.cg.vehicle.vehi.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.vehicle.vehi.Customer;
import com.cg.vehicle.vehi.util.DBConnection;

public class IVehicleDaoImpl implements IVehicleDao{

	@Override
	public String addCustomer(Customer cust) throws ClassNotFoundException, SQLException, IOException {
		Connection con = DBConnection.getConnection();
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String custId = null;
		//int queryResult = 0;

		try {
			
			
			pst = con.prepareStatement("insert into customer values(custId_sequence.nextval,?,?,?,SYSDATE)");
			pst.setString(1,cust.getName());
			pst.setString(2,cust.getAddress());
			pst.setString(3,cust.getPhoneNumber());
			
			

			pst.executeUpdate();
			st=con.createStatement();
			rs =st.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				custId = rs.getString(1);
				System.out.println("Hi"+cust.getName());
				/*rs.getString(2);
				rs.getString(3);
				rs.getString(3);*/

			}

		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
      con.close();
      st.close();
      pst.close();
		return custId;
		
	}

	
	
	


	@Override
	public String ViewCar() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String ViewBike() {
		// TODO Auto-generated method stub
		return null;
	}

}
