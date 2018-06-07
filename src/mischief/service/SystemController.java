package mischief.service;

import java.util.List;

import mischief.domain.Book;
import mischief.domain.Member;
import mischief.domain.Role;
import mischief.domain.Staff;

/**
 * @author uka
 *
 */
public class SystemController {
	private static Staff staff;

	public Member getMemberByID(String memberID) {
		List<Member> memberList = ServiceFactory.getDataAccessService().getMemberList();

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberID().equals(memberID))
				return memberList.get(i);
		}

		return null;
	}

	public static void main(String[] args) {

		System.out.println("***LOGIN FORM STARTED***");
		staff = login("admin", "4321");

		if (staff == null) {
			System.out.println("***INVALID CREDENTIALS***");
			return;
		}
		System.out.println("***AUTHORIZATION LEVEL***" + staff.getRole().getValue());

		// 2. add new library member
		addMember("1", "John", "Joy", "999", "2000 north court street", "Fairfield", "IOWA", "52556");

		// 3. uka

		// 4. add copy of existing book
		addBookCopy("000-001", "1");

	}

	private static void addBookCopy(String isbn, String copyNumber) {
		if (isAdmin()) {
			BookService bookService = ServiceFactory.getBookService();
			Book book = bookService.getBookByISBN(isbn);
			if (book != null) {
				bookService.addBookCopy(book, copyNumber);
			} else {
				System.out.println("BOOK NOT FOUND!");
			}

		} else {
			System.out.println("NO PERMISSION!");
		}
	}

	private static void addMember(String memberID, String firstName, String lastName, String phoneNumber, String street,
			String city, String state, String zip) {

		if (isAdmin()) {
			MemberService memberService = ServiceFactory.getMemberService();
			memberService.addMember(memberID, firstName, lastName, phoneNumber, street, city, state, zip);

		} else {
			System.out.println("NO PERMISSION!");
		}

	}

	private static boolean isLibrarian() {
		boolean isLibrarian = staff.getRole().getValue().equals(Role.LIBRARIAN.getValue())
				|| staff.getRole().getValue().equals(Role.BOTH.getValue()) ? true : false;
		return isLibrarian;
	}

	private static boolean isAdmin() {
		boolean isAdmin = staff.getRole().getValue().equals(Role.ADMIN.getValue())
				|| staff.getRole().getValue().equals(Role.BOTH.getValue()) ? true : false;
		return isAdmin;
	}

	private static Staff login(String id, String pass) {

		LoginService service = ServiceFactory.getLoginService();
		Staff staff = service.getAuthorization(id, pass);

		return staff;

	}

}