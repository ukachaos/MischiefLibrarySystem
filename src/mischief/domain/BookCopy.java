package mischief.domain;

/**
 * @author uka
 *
 */
public class BookCopy {
	String copyNumber;
	boolean available = true;

	public BookCopy(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public boolean isAvailable() {
		return available;
	}
}
