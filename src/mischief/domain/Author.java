package mischief.domain;

/**
 * @author uka
 *
 */
public class Author extends Person{

	public String credentials;
	public String shortBio;
	
	public Author(String firstName, String lastName, String phoneNumber, Address address, String credendials, String shortBio) {
		super(firstName, lastName, phoneNumber, address);
		this.credentials = credendials;
		this.shortBio = shortBio;
	}
}
