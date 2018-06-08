package mischief.domain;

/**
 * @author uka
 *
 */

public class Staff extends Person {

	private String id;
	private String pass;
	private Role role;

	public Staff(String id, String pass, Role role, String firstName, String lastName, String phoneNumber,
			Address address) {
		super(firstName, lastName, phoneNumber, address);
		this.id = id;
		this.pass = pass;
		this.role = role;
	}

	public boolean checkCredential(String inputID, String inputPass) {
		if (this.id.equalsIgnoreCase(inputPass) && this.pass.equalsIgnoreCase(inputPass))
			return true;
		else
			return false;
	}

	public Role getRole() {
		return role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
