package mischief.domain;

/**
 * @author uka
 *
 */
public class BookCopy {
	String id;
	boolean available = true;
	
	public BookCopy(String id) {
		this.id = id;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isAvailable() {
		return available;
	}
}
