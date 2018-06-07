package mischief.service;

import mischief.domain.Address;
import mischief.domain.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void addMember(String memberID, String firstName, String lastName, String phoneNumber, String street,
			String city, String state, String zip) {

		Address address = new Address(street, city, state, zip);

		Member member = new Member(memberID, firstName, lastName, phoneNumber, address);
		
		DataAccessService dataAccessService = ServiceFactory.getDataAccessService();
		dataAccessService.saveNewMember(member);
		

	}

}
