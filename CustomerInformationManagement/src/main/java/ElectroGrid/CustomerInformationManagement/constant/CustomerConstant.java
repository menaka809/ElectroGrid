package ElectroGrid.CustomerInformationManagement.constant;

public class CustomerConstant {
	public static String GETALLCUSTOMER = "select customerName,customerPhoneNo,email,houseNo,street,city,zipCode,serviceStartDate from customer";
	public static String CREATECUSTOMER = "insert into customer  values (?,?,?,?,?,?,?,?,?)";
	public static String GGETCUSTOMERBYID = "SELECT * FROM customer WHERE cusId = ?";
	public static String UPDATECUSTOMER = "UPDATE customer SET cusId = ? , customerName = ? , customerPhoneNo = ? , email = ? , houseNo = ?,street = ? , city = ? , zipCode = ? , serviceStartDate = ? WHERE cusId = ?";
	public static String DELETECUSTOMER = "DELETE FROM customer WHERE cusId = ?";


}
