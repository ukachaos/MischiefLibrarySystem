package mischief.service;

import java.util.ArrayList;
import java.util.List;

import mischief.domain.Address;
import mischief.domain.Book;
import mischief.domain.BookCopy;
import mischief.domain.Member;
import mischief.domain.Role;
import mischief.domain.Staff;

public class DataAccessServiceImpl implements DataAccessService {

	static List<Member> memberList;
	static List<Book> bookList;
	static List<Staff> staffList;

	Address address = new Address();

	public DataAccessServiceImpl() {
		memberList = new ArrayList<>();
		bookList = new ArrayList<>();
		staffList = new ArrayList<>();

		initBooks();
		initStaff();
		initMembers();
	}

	public void initBooks() {
		Book b1 = new Book("Harry Potter", "000-001", 3);
		Book b2 = new Book("Hunger Games", "000-002", 3);
		Book b3 = new Book("Divergent", "000-003", 1);
		Book b4 = new Book("The Maze Runner", "000-004", 1);
		Book b5 = new Book("Core Java", "000-005", 1);

		bookList.add(b1);
		b1.checkoutBook("000-001-000");
		bookList.add(b2);
		b2.checkoutBook("000-002-000");
		bookList.add(b3);
		b3.checkoutBook("000-003-000");
		bookList.add(b4);
		b4.checkoutBook("000-004-000");
		bookList.add(b5);
	}

	public void initMembers() {
		Member m1 = new Member("001", "Uka", "Uka", "000-000-0000", address);
		Member m2 = new Member("002", "Son", "Son", "000-000-0000", address);
		Member m3 = new Member("003", "Eric", "Eric", "000-000-0000", address);
		Member m4 = new Member("004", "Maral", "Maral", "000-000-0000", address);

		memberList.add(m1);
		memberList.add(m2);
		memberList.add(m3);
		memberList.add(m4);

		m1.createCheckoutEntry("000-001-000", 21);
		m2.createCheckoutEntry("000-002-000", 7);
		m3.createCheckoutEntry("000-003-000", -7);
		m4.createCheckoutEntry("000-005-000", -10);
	}

	public void initStaff() {
		Staff s1 = new Staff("librarian", "1234", Role.LIBRARIAN, "Librarian", "Librarian", "000-000-0000", address);
		Staff s2 = new Staff("admin", "4321", Role.ADMIN, "Librarian", "Librarian", "000-000-0000", address);
		staffList.add(s1);
		staffList.add(s2);
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	@Override
	public void saveNewMember(Member member) {
		memberList.add(member);
		System.out.println("MemberId : " + member.getMemberID() + ", firstName : " + member.getFirstName()
				+ ", lastName:  " + member.getLastName() + " added.");
	}

	@Override
	public void saveBookCopy(Book book, BookCopy copy) {
		book.getBookCopyList().add(copy);
		System.out.println("copyNumber : " + copy.getCopyNumber() + " in book title:  " + book.getTitle()
				+ ", book ISBN : " + book.getISBN() + " added.");

	}

}
