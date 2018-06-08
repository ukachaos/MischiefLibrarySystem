package mischief.service;

import mischief.domain.Member;

public interface MemberService {

	void addMember(String memberID, String firstName, String lastName, String phoneNumber, String street, String city,
			String state, String zip);
	
	public Member getMemberByID(String memberID);

}
