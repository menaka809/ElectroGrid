package ElectroGrid.UnitManagement.modal;

public class Unit {
	private int unitsId;
	private String date;
	private String validMonth;
	private String unitRange;
	private int unitPrice;
	
	
	public Unit() {
		super();
	}


	public Unit(int unitsId, String date, String validMonth, String unitRange, int unitPrice) {
		super();
		this.unitsId = unitsId;
		this.date = date;
		this.validMonth = validMonth;
		this.unitRange = unitRange;
		this.unitPrice = unitPrice;
	}


	public int getUnitsId() {
		return unitsId;
	}


	public void setUnitsId(int unitsId) {
		this.unitsId = unitsId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getValidMonth() {
		return validMonth;
	}


	public void setValidMonth(String validMonth) {
		this.validMonth = validMonth;
	}


	public String getUnitRange() {
		return unitRange;
	}


	public void setUnitRange(String unitRange) {
		this.unitRange = unitRange;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		return "Unit [unitsId=" + unitsId + ", date=" + date + ", validMonth=" + validMonth
				+ ", unitRange=" + unitRange + ", unitPrice=" + unitPrice + "]";
	}
	
	

}
