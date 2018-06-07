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
}
