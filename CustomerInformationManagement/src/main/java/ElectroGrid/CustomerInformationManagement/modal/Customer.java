package ElectroGrid.CustomerInformationManagement.modal;

public class Customer {
	private int cusId;
	private String customerName;
	private String customerPhoneNo;
	private String email;
	private String houseNo;
	private String street;
	private String city;
	private String zipCode;
	private String serviceStartDate;
	

	
	public Customer() {
		
	}
	
	public Customer(int cusId, String customerName, String customerPhoneNo, String email, String houseNo, String street,
			String city, String zipCode, String serviceStartDate) {
		super();
		this.cusId = cusId;
		this.customerName = customerName;
		this.customerPhoneNo = customerPhoneNo;
		this.email = email;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.serviceStartDate = serviceStartDate;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId+ ", customerName=" + customerName + ", customerPhoneNo=" + customerPhoneNo
				+ ", email=" +email + ", houseNo=" + houseNo+", street=" + street +", city=" + city +", zipCode=" + zipCode +", serviceStartDate=" + serviceStartDate +"]";
	}
	
	
}
