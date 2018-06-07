package mischief.domain;

/**
 * @author uka
 *
 */
public class Member extends Person{
	
	private String memberID;
	
	public Member(String memberID, String firstName, String lastName, String phoneNumber, Address address) {
		super(firstName, lastName, phoneNumber, address);
		
		this.memberID = memberID;
	}
	
	public String getMemberID() {
		return memberID;
	}
}
