package mischief.service;

public class ServiceFactory {
	private volatile static LoginService loginService;
	private volatile static DataAccessService dataAccessService;

	public static LoginService getLoginService() {
		if (null == loginService) {
			synchronized (ServiceFactory.class) {
				if (null == loginService) {
					loginService = new LoginServiceImpl();
				}
			}
		}
		return loginService;
	}

	public static DataAccessService getDataAccessService() {
		if (null == dataAccessService) {
			synchronized (ServiceFactory.class) {
				if (null == dataAccessService) {
					dataAccessService = new DataAccessServiceImpl();
				}
			}
		}
		return dataAccessService;
	}
}
