package mischief.service;

import mischief.domain.Book;

public interface BookService {

	Book getBookByISBN(String isbn);

	void addBookCopy(Book book, String copyNumber);

}
