package mischief.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uka
 *
 */
public class Book {
	int availableCopy;
	String title;
	String ISBN;
	int maxCheckoutLength = 21;
	
	List<Author> authorList;
	
	List<BookCopy> bookCopy;
	
	CheckoutRecord checkoutRecord;
	
	public Book(String title, String ISBN, int availableCopy) {
		this.title = title;
		this.ISBN = ISBN;
		this.availableCopy = availableCopy;
		
		bookCopy = new ArrayList<>();
		
		for(int i = 0; i < availableCopy; i++) {
			String id = ISBN + "-00" + i;
			BookCopy copy = new BookCopy(id);
			
			System.out.println("----" + title + " with id:" + id + " createad");
			
			bookCopy.add(copy);
		}
		
		authorList = new ArrayList<>();
		
		checkoutRecord = new CheckoutRecord();
	}
	
	public void addAuthor(Author author) {
		authorList.add(author);
	}
}
