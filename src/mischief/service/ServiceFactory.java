package mischief.service;

public class ServiceFactory {
	private volatile static LoginService loginService;
	private volatile static BookService bookService;
	private volatile static MemberService memberService;
	private volatile static DataAccessService dataAccessService;

	public static BookService getBookService() {
		if (null == bookService) {
			synchronized (ServiceFactory.class) {
				if (null == bookService) {
					bookService = new BookServiceImpl();
				}
			}
		}
		return bookService;
	}

	public static MemberService getMemberService() {
		if (null == memberService) {
			synchronized (ServiceFactory.class) {
				if (null == memberService) {
					memberService = new MemberServiceImpl();
				}
			}
		}
		return memberService;
	}

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
