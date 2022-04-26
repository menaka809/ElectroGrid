package ElectroGrid.UnitManagement.constant;

public class UnitConstant {
	public static String GETALLUNITS = "select date,validMonth,unitRange,unitPrice  from units";
	public static String CREATEUNITS = "insert into units  values (?,?,?,?,?)";
	public static String GETUNITSBYID = "SELECT * FROM units WHERE unitsId = ?";
	public static String UPDATEUNITS = "UPDATE units SET unitsId =? ,date = ? , validMonth = ? , unitRange = ? , unitPrice = ? WHERE unitsId = ?";
	public static String DELETEUNITS = "DELETE FROM units WHERE unitsId = ?";
}
