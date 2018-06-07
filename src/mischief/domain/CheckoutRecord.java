package mischief.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uka
 *
 */
public class CheckoutRecord {
	List<CheckoutEntry> checkoutEntryList;
	
	public CheckoutRecord() {
		checkoutEntryList = new ArrayList<>();
	}
	
	public void createCheckoutEntry(String bookID, int maxCheckoutLength) {
		CheckoutEntry entry = new CheckoutEntry(bookID, maxCheckoutLength);
		checkoutEntryList.add(entry);
	}
}
