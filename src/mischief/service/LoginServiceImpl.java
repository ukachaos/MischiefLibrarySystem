package mischief.service;

import java.util.List;

import mischief.domain.Staff;

public class LoginServiceImpl implements LoginService {

	@Override
	public Staff getAuthorization(String id, String pass) {
		DataAccessService service = ServiceFactory.getDataAccessService();
		List<Staff> staffList = service.getStaffList();

		Staff response = null;

		for (Staff staff : staffList) {
			if (staff.getId().equals(id) && staff.getPass().equals(pass)) {
				response = staff;
				break;
			}
		}

		return response;

	}

}
