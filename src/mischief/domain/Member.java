package mischief.domain;

/**
 * @author uka
 *
 */
public class Member extends Person{
	
	private String memberID;
	
	private CheckoutRecord checkoutRecord;
	
	public Member(String memberID, String firstName, String lastName, String phoneNumber, Address address) {
		super(firstName, lastName, phoneNumber, address);
		
		this.memberID = memberID;
		
		checkoutRecord = new CheckoutRecord();
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public CheckoutEntry createCheckoutEntry(String bookID, int maxCheckoutLength) {
		return checkoutRecord.createCheckoutEntry(bookID, maxCheckoutLength);
	}
}
