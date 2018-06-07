package mischief.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author uka
 *
 */
public class CheckoutEntry {
	String bookID;
	LocalDate checkoutDate;
	LocalDate dueDate;
	
	LocalDate checkinDate;
	
	boolean hasPaid;
	LocalDate paidDate;
	
	
	public CheckoutEntry(String bookID, int maxCheckoutLength) {
		this.bookID = bookID;
		
		checkoutDate = LocalDate.now();
		
		dueDate = checkoutDate.plus(maxCheckoutLength, ChronoUnit.DAYS);
		
		System.out.println("Checkout entry record(" + bookID + " - " + checkoutDate + " - " + dueDate + ") created");
	}
}
