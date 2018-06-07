package mischief.service;

import java.util.ArrayList;
import java.util.List;

import mischief.domain.Address;
import mischief.domain.Book;
import mischief.domain.Member;
import mischief.domain.Role;
import mischief.domain.Staff;

/**
 * @author uka
 *
 */
public class DataAccessService {
	static List<Member> memberList;
	static List<Book> bookList;
	static List<Staff> staffList;
	
	Address address = new Address();
	
	public DataAccessService() {
		memberList = new ArrayList<>();
		bookList = new ArrayList<>();
		staffList = new ArrayList<>();
		
		initBooks();
		initStaff();
		initMembers();
	}
	
	void initBooks() {
		Book b1 = new Book("Harry Potter", "000-001", 3);
		Book b2 = new Book("Hunger Games", "000-002", 3);
		Book b3 = new Book("Divergent", "000-003", 1);
		Book b4 = new Book("The Maze Runner", "000-004", 1);
		Book b5 = new Book("Core Java", "000-005", 1);
		
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);
		bookList.add(b5);
	}
	
	void initMembers() {
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
	
	void initStaff() {
		Staff s1 = new Staff("librarian", "1234", Role.LIBRARION, "Librarian", "Librarian", "000-000-0000", address);
		Staff s2 = new Staff("admin", "4321", Role.ADMIN, "Librarian", "Librarian", "000-000-0000", address);
		staffList.add(s1);
		staffList.add(s2);
	}
	
	public List<Member> getMemberList(){
		return memberList;
	}
	
	public List<Book> getBookList(){
		return bookList;
	}
	
	public List<Staff> getsaffList(){
		return staffList;
	}
}
