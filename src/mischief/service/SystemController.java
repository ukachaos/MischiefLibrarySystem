package mischief.service;

import java.util.List;

import mischief.domain.Member;

/**
 * @author uka
 *
 */
public class SystemController {
	DataAccessService dataAccessService;
	
	public SystemController() {
		dataAccessService = new DataAccessService();
	}
	
	public Member getMemberByID(String memberID) {
		List<Member> memberList = dataAccessService.getMemberList();
		
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getMemberID().equals(memberID)) 
				return memberList.get(i);
		}
		
		return null;
	}
}
