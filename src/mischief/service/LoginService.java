package mischief.service;

import mischief.domain.Staff;

public interface LoginService {

	Staff getAuthorization(String id, String pass);

}
