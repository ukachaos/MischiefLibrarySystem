package mischief.service;

import java.util.List;

import mischief.domain.Book;
import mischief.domain.BookCopy;
import mischief.domain.Member;

import mischief.domain.Staff;

/**
 * @author uka
 *
 */

public interface DataAccessService {

	void initBooks();

	void initMembers();

	void initStaff();

	List<Member> getMemberList();

	List<Book> getBookList();

	List<Staff> getStaffList();

	void saveNewMember(Member member);

	void saveBookCopy(Book book, BookCopy copy);
}
