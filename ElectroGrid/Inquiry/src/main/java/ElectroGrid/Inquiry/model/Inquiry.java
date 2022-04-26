package ElectroGrid.Inquiry.model;

public class Inquiry {
	

	private int inquiryId;
	private String customerId;
	private String customerName;
	private String customerNIC;
	private int contactNo;
	private String inquiryType;
	private String inquiryDate;
	private String description;
	public Inquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Inquiry(int inquiryId, String customerId, String customerName, String customerNIC, int contactNo,
			String inquiryType, String inquiryDate, String description) {
		super();
		this.inquiryId = inquiryId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNIC = customerNIC;
		this.contactNo = contactNo;
		this.inquiryType = inquiryType;
		this.inquiryDate = inquiryDate;
		this.description = description;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNIC() {
		return customerNIC;
	}

	public void setCustomerNIC(String customerNIC) {
		this.customerNIC = customerNIC;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(String inquiryType) {
		this.inquiryType = inquiryType;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}
