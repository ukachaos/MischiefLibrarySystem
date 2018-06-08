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

	List<BookCopy> bookCopies;

	CheckoutRecord checkoutRecord;

	public Book(String title, String ISBN, int availableCopy) {
		this.title = title;
		this.ISBN = ISBN;
		this.availableCopy = availableCopy;

		bookCopies = new ArrayList<>();

		for (int i = 0; i < availableCopy; i++) {
			String id = ISBN + "-00" + i;
			BookCopy copy = new BookCopy(id);

			System.out.println("----" + title + " with id:" + id + " createad");

			bookCopies.add(copy);
		}

		authorList = new ArrayList<>();

		checkoutRecord = new CheckoutRecord();
	}

	public void addAuthor(Author author) {
		authorList.add(author);
	}

	public int getAvailableCopy() {
		return availableCopy;
	}

	public void setAvailableCopy(int availableCopy) {
		this.availableCopy = availableCopy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<BookCopy> getBookCopyList() {
		return bookCopies;
	}

	public void setBookCopy(List<BookCopy> bookCopy) {
		this.bookCopies = bookCopy;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
	
	public boolean checkoutBook(String bookID) {
		if(availableCopy > 0)
		{
			for(BookCopy bc : bookCopies) {
				if(bc.getCopyNumber().equals(bookID)) {
					if(bc.available) {
						bc.setAvailable(false);
						availableCopy --;
						return true;
					}
					else return false;
				}
			}
			
			return false;
		}
		else return false;
	}
	
	public void checkinBook(String bookID) {
		availableCopy ++;
		for(BookCopy bc : bookCopies) {
			if(bc.getCopyNumber().equals(bookID)){
				bc.setAvailable(true);
			}
		}
	}
}
