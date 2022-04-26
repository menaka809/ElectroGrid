package ElectroGrid.Inquiry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DatabaseConnection;
import ElectroGrid.Inquiry.model.Inquiry;

public class InquiryService {
	
	//Get All the Inquiry
	public static List<Inquiry> getAllInquiry() throws ClassNotFoundException, SQLException{
		
		
		Connection con=DatabaseConnection.getConnection();
		String query="select * from inquiry ";
		PreparedStatement preparedstatement=con.prepareStatement(query);
		ResultSet result = preparedstatement.executeQuery(query);
		List<Inquiry> list=new ArrayList<>();
		while(result.next()) {
			 Inquiry inquiry=new Inquiry();
			 inquiry.setInquiryId(result.getInt(1));
			 inquiry.setCustomerId(result.getString(2));
			 inquiry.setCustomerName(result.getString(3));
			 inquiry.setCustomerNIC(result.getString(4));
			 inquiry.setContactNo(result.getInt(5));
			 inquiry.setInquiryType(result.getString(6));
			 inquiry.setInquiryDate(result.getString(7));
			 inquiry.setDescription(result.getString(8));
			 	
				
			 list.add(inquiry);
			
		
		}
	
		
		 return list;
	}
	//Get one Inquiry using InquiryId
	public static ArrayList<Inquiry> getOneInquiry(String id) throws ClassNotFoundException, SQLException{
		
		
		Connection con=DatabaseConnection.getConnection();
		int Id=Integer.parseInt(id);
		String query="select * from inquiry where inquiryId='"+Id+"'";
		PreparedStatement preparedstatement=con.prepareStatement(query);
		ResultSet result = preparedstatement.executeQuery(query);
		ArrayList<Inquiry> list=new ArrayList<>();
		while(result.next()) {
			 Inquiry inquiry=new Inquiry();
			 inquiry.setInquiryId(result.getInt(1));
			 inquiry.setCustomerId(result.getString(2));
			 inquiry.setCustomerName(result.getString(3));
			 inquiry.setCustomerNIC(result.getString(4));
			 inquiry.setContactNo(result.getInt(5));
			 inquiry.setInquiryType(result.getString(6));
			 inquiry.setInquiryDate(result.getString(7));
			 inquiry.setDescription(result.getString(8));	
				
			 list.add(inquiry);
			
		
		}
	
		
		 return list;
	}

	//Create Inquiry 
	public static Inquiry createInquiry(Inquiry inquiry) throws ClassNotFoundException, SQLException {
		Connection con=DatabaseConnection.getConnection();
		String query="insert into  inquiry values(?,?,?,?,?,?,?,?) ";
		PreparedStatement preparedstatement=con.prepareStatement(query);
		int id=0;
		String nic=inquiry.getCustomerNIC();
		preparedstatement.setInt(1,id);
		preparedstatement.setString(2, inquiry.getCustomerId());
		preparedstatement.setString(3, inquiry.getCustomerName());
		preparedstatement.setString(4, inquiry.getCustomerNIC());
		preparedstatement.setInt(5, inquiry.getContactNo());
		preparedstatement.setString(6, inquiry.getInquiryType());
		preparedstatement.setString(7, inquiry.getInquiryDate());
		preparedstatement.setString(8, inquiry.getDescription());
		
		boolean isCreate=preparedstatement.execute();
		if(!isCreate) {
			
			return inquiry;
		}else {
			return null;
		}
		
		
	}
	
	//Update Inquiry 
	public static Inquiry updateInquiry(Inquiry inquiry,String id) throws ClassNotFoundException, SQLException {
		Connection con=DatabaseConnection.getConnection();
		
		String query="update inquiry set inquiryId=?,customerId=?,customerName=?,customerNIC=?,contactNo=?,inquirytype=?,inquiryDate=?,description=?  where inquiryId='"+id+"' ";
		PreparedStatement preparedstatement=con.prepareStatement(query);
		int inquiryId = Integer.parseInt(id);
		preparedstatement.setInt(1, inquiryId);
		preparedstatement.setString(2, inquiry.getCustomerId());
		preparedstatement.setString(3, inquiry.getCustomerName());
		preparedstatement.setString(4, inquiry.getCustomerNIC());
		preparedstatement.setInt(5, inquiry.getContactNo());
		preparedstatement.setString(6, inquiry.getInquiryType());
		preparedstatement.setString(7, inquiry.getInquiryDate());
		preparedstatement.setString(8, inquiry.getDescription());

		//System.out.println("hello");
		int isUpdate=preparedstatement.executeUpdate();
		if(isUpdate>0) {
			return inquiry;
		}else {
			return null;
		}
		
		
	}
	//delete Inquiry
	public static boolean deleteInquiry(String id) throws ClassNotFoundException, SQLException {
		int Id=Integer.parseInt(id);
		Connection con=DatabaseConnection.getConnection();
		System.out.println(Id);
		String query="DELETE FROM inquiry WHERE inquiryId="+Id+"";
		
		Statement  statement=con.createStatement();
		int result = statement.executeUpdate(query);
//		int result = preparedstatement.executeUpdate();
		if(result>0)
			return true;
		else
			return false;
	}
}
