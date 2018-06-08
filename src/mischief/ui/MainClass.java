package mischief.ui;

import mischief.domain.CheckoutEntry;
import mischief.domain.Staff;
import mischief.service.SystemController;

/**
 * @author uka
 *
 */
public class MainClass {
	
	static SystemController systemController;
	
	public static void main(String[] args) {
		systemController = new SystemController();
		
		System.out.println("***LOGIN FORM STARTED***");
		Staff staff = systemController.login("admin", "4321");

		if (staff == null) {
			System.out.println("***INVALID CREDENTIALS***");
			return;
		}
		System.out.println("***AUTHORIZATION LEVEL***" + staff.getRole().getValue());

		// 2. add new library member
		try {
			systemController.addMember("1", "John", "Joy", "999", "2000 north court street", "Fairfield", "IOWA", "52556");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

		// 3. uka
		try {
			CheckoutEntry entry = systemController.checkoutBook("001", "000-001-000");
			
			if(entry != null) {
				System.out.println("Checkout successfull");
			}
			else System.out.println("Checkout not successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		try {
			CheckoutEntry entry = systemController.checkoutBook("001", "000-001-002");
			
			if(entry != null) {
				System.out.println("Checkout successfull");
			}
			else System.out.println("Checkout not successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		// 4. add copy of existing book
		try {
			systemController.addBookCopy("000-001", "1");
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
