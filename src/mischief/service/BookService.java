package mischief.service;

import mischief.domain.Book;
import mischief.domain.BookCopy;

public interface BookService {

	public Book getBookByISBN(String isbn);
	public Book getBookByID(String id) throws Exception;

	void addBookCopy(Book book, String copyNumber);

}
