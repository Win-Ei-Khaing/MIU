package prob2;

public class LibraryMember {
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private CheckoutRecord checkoutRecord;
	
	public LibraryMember(String id, String fName, String lName, String phone) {
		memberId = id;
		firstName = fName;
		lastName = lName;
		this.phone = phone;
		this.checkoutRecord = new CheckoutRecord();
	}
	
	public String getMemberId() {
		return memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	
	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}
