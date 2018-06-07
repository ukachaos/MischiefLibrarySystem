package mischief.service;

/**
 * @author uka
 *
 */
public class SystemController {

	public static void main(String[] args) {

		login("1", "123");

	}

	private static void login(String id, String pass) {

		LoginService service = ServiceFactory.getLoginService();
		Staff role = service.getAuthorization(id, pass);
	}
}
