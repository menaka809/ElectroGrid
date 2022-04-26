package ElectroGrid.UnitManagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ElectroGrid.UnitManagement.constant.Constant;
import ElectroGrid.UnitManagement.constant.UnitConstant;
import ElectroGrid.UnitManagement.modal.Unit;
import ElectroGrid.UnitManagement.util.DatabaseConnection;

public class UnitController {
	//get all
	public static ArrayList<Unit> getUnitInformation() throws ClassNotFoundException, SQLException {
		ArrayList<Unit> plist = new ArrayList<>();
		String getQury = UnitConstant.GETALLUNITS;
		Connection con = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) {
			Unit unit = new Unit();
			unit.setDate(rs.getString(Constant.INDEX_ONE));
			unit.setValidMonth(rs.getString(Constant.INDEX_TWO));
			unit.setUnitRange(rs.getString(Constant.INDEX_TREE));
			unit.setUnitPrice(rs.getInt(Constant.INDEX_FOUR));
			
			


			plist.add(unit);
		}
		
		return plist;

	}
	
	//create
	public static Unit createUnitInformation(Unit unit) throws SQLException, ClassNotFoundException {
		String CreateQury =UnitConstant.CREATEUNITS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		preparedStatement.setInt(Constant.INDEX_ONE, unit.getUnitsId());
		preparedStatement.setString(Constant.INDEX_TWO, unit.getDate());
		preparedStatement.setString(Constant.INDEX_TREE, unit.getValidMonth());
		preparedStatement.setString(Constant.INDEX_FOUR, unit.getUnitRange());
		preparedStatement.setInt(Constant.INDEX_FIVE, unit.getUnitPrice());

		
				  
		boolean isCreate = preparedStatement.execute();
	    if(!isCreate) {
	    	return unit;
		}
		else {
			System.out.println("hi");
			return null;
		}
	}
	
	//get by ID
	
	public static Unit getUnitInformationByID(int unId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = UnitConstant.GETUNITSBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Unit unit = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, unId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int unitsId = rs.getInt(Constant.INDEX_ONE);
			String date = rs.getString(Constant.INDEX_TWO);
			String validMonth = rs.getString(Constant.INDEX_TREE);
			String unitRange = rs.getString(Constant.INDEX_FOUR);
			int unitPrice = rs.getInt(Constant.INDEX_FIVE);
			

			unit = new Unit(unitsId, date, validMonth, unitRange,unitPrice);
		}
		return unit;
				
	}
	
	//Update
	public static Unit updateUnitInformation(Unit unit,int unId) throws SQLException, ClassNotFoundException {
		
//		String update_query = UserUsageInformationConstant.UPDATEUSERUSAGEINFORMATION;
		String update_query = "UPDATE units SET unitsId =? ,date = ? , validMonth = ? , unitRange = ? , unitPrice = ? WHERE unitsId =  '"+unId+"'";;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, unit.getUnitsId());
		preparedStatement.setString(Constant.INDEX_TWO, unit.getDate());
		preparedStatement.setString(Constant.INDEX_TREE, unit.getValidMonth());
		preparedStatement.setString(Constant.INDEX_FOUR, unit.getUnitRange());
		preparedStatement.setInt(Constant.INDEX_FIVE, unit.getUnitPrice());
		

		
				
		if(preparedStatement.executeUpdate() > 0) {
			return getUnitInformationByID(unId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteUnitInformation(int unId) throws SQLException, ClassNotFoundException {
		
		String delete_query =UnitConstant.DELETEUNITS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, unId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}
	
	

}
