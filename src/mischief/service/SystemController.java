package mischief.service;

import java.util.List;

import mischief.domain.Book;
import mischief.domain.BookCopy;
import mischief.domain.CheckoutEntry;
import mischief.domain.CheckoutRecord;
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

	public void addBookCopy(String isbn, String copyNumber) throws Exception{
		if (isAdmin()) {
			BookService bookService = ServiceFactory.getBookService();
			Book book = bookService.getBookByISBN(isbn);
			if (book != null) {
				bookService.addBookCopy(book, copyNumber);
			} else {
				throw new MischiefException("Book not found!!!");
			}

		} else {
			throw new MischiefException("No Permission!!!");
		}
	}

	public void addMember(String memberID, String firstName, String lastName, String phoneNumber, String street,
			String city, String state, String zip) throws Exception{

		if (isAdmin()) {
			MemberService memberService = ServiceFactory.getMemberService();
			memberService.addMember(memberID, firstName, lastName, phoneNumber, street, city, state, zip);

		} else {
			throw new MischiefException("No Permission!!!");
		}

	}

	private boolean isLibrarian() {
		boolean isLibrarian = staff.getRole().getValue().equals(Role.LIBRARIAN.getValue())
				|| staff.getRole().getValue().equals(Role.BOTH.getValue()) ? true : false;
		return isLibrarian;
	}

	private boolean isAdmin() {
		boolean isAdmin = staff.getRole().getValue().equals(Role.ADMIN.getValue())
				|| staff.getRole().getValue().equals(Role.BOTH.getValue()) ? true : false;
		return isAdmin;
	}

	public Staff login(String id, String pass) {

		LoginService service = ServiceFactory.getLoginService();
		Staff staff = service.getAuthorization(id, pass);
		
		this.staff = staff;

		return staff;

	}
	
	//Added by Uka
	public CheckoutEntry checkoutBook(String memberID, String bookID) throws Exception{
		MemberService service = ServiceFactory.getMemberService();
		
		Member member = service.getMemberByID(memberID);
		
		if(member != null) {
			try {
				Book book = ServiceFactory.getBookService().getBookByID(bookID);
				
				if(book.checkoutBook(bookID)) {
					return member.createCheckoutEntry(bookID, book.getMaxCheckoutLength());
				}
				else throw new MischiefException("BookCopy with " + bookID + " id is not available");
			}
			catch(Exception e) {
				throw e;
			}
			
		}
		else {
			throw new MischiefException("Member with " + memberID + " id not found");
		}
	}
}
