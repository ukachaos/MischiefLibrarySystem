package mischief.ui;

import mischief.domain.Member;
import mischief.service.SystemController;

/**
 * @author uka
 *
 */
public class MainClass {
	
	static SystemController systemController;
	
	public static void main(String[] args) {
		systemController = new SystemController();
		Member member = systemController.getMemberByID("002");
		System.out.println(member.firstName);
		//Login
		
		//Add library member
		
		//Checkout book
		
		//Add existing copy of book
		
	}
}
