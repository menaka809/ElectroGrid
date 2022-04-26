package ElectroGrid.CustomerInformationManagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ElectroGrid.CustomerInformationManagement.constant.Constant;
import ElectroGrid.CustomerInformationManagement.constant.CustomerConstant;
import ElectroGrid.CustomerInformationManagement.modal.Customer;
import ElectroGrid.CustomerInformationManagement.util.DatabaseConnection;


public class CustomerController {
	//get all
	public static ArrayList<Customer> getCustomerInformation() throws ClassNotFoundException, SQLException {
		ArrayList<Customer> plist = new ArrayList<>();
		String getQury = CustomerConstant.GETALLCUSTOMER;
		Connection con = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) {
			Customer customer = new Customer();
			
			customer.setCustomerName(rs.getString(Constant.INDEX_ONE));
			customer.setCustomerPhoneNo(rs.getString(Constant.INDEX_TWO));
			customer.setEmail(rs.getString(Constant.INDEX_TREE));
			customer.setHouseNo(rs.getString(Constant.INDEX_FOUR));
			customer.setStreet(rs.getString(Constant.INDEX_FIVE));
			customer.setCity(rs.getString(Constant.INDEX_SIX));
			customer.setZipCode(rs.getString(Constant.INDEX_SEVEN));
			customer.setServiceStartDate(rs.getString(Constant.INDEX_EIGHT));
			
			


			plist.add(customer);
		}
		
		return plist;

	}
	
	public static Customer createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		String CreateQury =CustomerConstant.CREATECUSTOMER;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		preparedStatement.setInt(Constant.INDEX_ONE, customer.getCusId());
		preparedStatement.setString(Constant.INDEX_TWO, customer.getCustomerName());
		preparedStatement.setString(Constant.INDEX_TREE, customer.getCustomerPhoneNo());
		preparedStatement.setString(Constant.INDEX_FOUR, customer.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, customer.getHouseNo());
		preparedStatement.setString(Constant.INDEX_SIX, customer.getStreet());
		preparedStatement.setString(Constant.INDEX_SEVEN, customer.getCity());
		preparedStatement.setString(Constant.INDEX_EIGHT, customer.getZipCode());
		preparedStatement.setString(Constant.INDEX_NINE, customer.getServiceStartDate());

		
				  
		boolean isCreate = preparedStatement.execute();
	    if(!isCreate) {
	    	return customer;
		}
		else {
			
			return null;
		}
	}
	
	//get by ID
	
	public static Customer getCustomerByID(int customerId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = CustomerConstant.GGETCUSTOMERBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Customer customer = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, customerId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int cusId = rs.getInt(Constant.INDEX_ONE);
			String customerName = rs.getString(Constant.INDEX_TWO);
			String customerPhoneNo = rs.getString(Constant.INDEX_TREE);
			String email = rs.getString(Constant.INDEX_FOUR);
			String houseNo = rs.getString(Constant.INDEX_FIVE);
			String street = rs.getString(Constant.INDEX_SIX);
			String city = rs.getString(Constant.INDEX_SEVEN);
			String zipCode = rs.getString(Constant.INDEX_EIGHT);
			String serviceStartDate = rs.getString(Constant.INDEX_NINE);
			

			customer = new Customer(cusId, customerName, customerPhoneNo,email,houseNo,street,city,zipCode,serviceStartDate);
		}
		return customer;
				
	}
	
	//Update
	public static Customer updateCustomerInformation(Customer customer,int customerId) throws SQLException, ClassNotFoundException {
		
//		String update_query = UserUsageInformationConstant.UPDATEUSERUSAGEINFORMATION;
		String update_query = "UPDATE customer SET cusId = ? , customerName = ? , customerPhoneNo = ? , email = ? , houseNo = ?,street = ? , city = ? , zipCode = ? , serviceStartDate = ? WHERE cusId ='"+customerId+"'";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, customer.getCusId());
		preparedStatement.setString(Constant.INDEX_TWO, customer.getCustomerName());
		preparedStatement.setString(Constant.INDEX_TREE, customer.getCustomerPhoneNo());
		preparedStatement.setString(Constant.INDEX_FOUR, customer.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, customer.getHouseNo());
		preparedStatement.setString(Constant.INDEX_SIX, customer.getStreet());
		preparedStatement.setString(Constant.INDEX_SEVEN, customer.getCity());
		preparedStatement.setString(Constant.INDEX_EIGHT, customer.getZipCode());
		preparedStatement.setString(Constant.INDEX_NINE, customer.getServiceStartDate());
		

		
				
		if(preparedStatement.executeUpdate() > 0) {
			return getCustomerByID(customerId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteCustomerInformation(int customerId) throws SQLException, ClassNotFoundException {
		
		String delete_query = CustomerConstant.DELETECUSTOMER;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, customerId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}
	

}
