package mischief.domain;

/**
 * @author uka
 *
 */
public enum Role {
	LIBRARIAN("LIBRARION"), ADMIN("ADMIN"), BOTH("BOTH");

	private final String role;

	Role(String role) {
		this.role = role;
	}

	public String getValue() {
		return this.role;
	}

}
