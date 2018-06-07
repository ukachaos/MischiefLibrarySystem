package mischief.domain;

/**
 * @author uka
 *
 */
public class Person {
	public String firstName;
	public String lastName;
	public String phoneNumber;

	public Address address;

	/**
	 * Main constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param address
	 */
	public Person(String firstName, String lastName, String phoneNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
