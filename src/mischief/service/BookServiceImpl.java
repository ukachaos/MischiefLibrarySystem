package mischief.service;

import java.util.List;

import mischief.domain.Book;
import mischief.domain.BookCopy;

public class BookServiceImpl implements BookService {

	DataAccessService service = ServiceFactory.getDataAccessService();

	@Override
	public Book getBookByISBN(String isbn) {
		List<Book> bookList = service.getBookList();

		Book response = null;

		for (Book book : bookList) {
			if (book.getISBN().equals(isbn)) {
				response = book;
				break;
			}
		}

		return response;
	}

	@Override
	public void addBookCopy(Book book, String copyNumber) {
		BookCopy copy = new BookCopy(copyNumber);
		service.saveBookCopy(book, copy);
	}
	
	@Override
	public Book getBookByID(String id) throws Exception{
		List<Book> bookList = service.getBookList();

		for (Book book : bookList) {
			if (id.contains(book.getISBN())) {
				return book;
			}
		}
		
		throw new MischiefException("Book with " + id + " id not found!");
	}

}
