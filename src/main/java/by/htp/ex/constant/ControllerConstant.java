package by.htp.ex.constant;

public class ControllerConstant {
	public static final String LOCAL = "local";
	public static final String ACTIVE = "active";
	public static final String NOT_ACTIVE = "not active";
	public static final String REGISTRATION_STATUS = "registration_status";
	public static final String AUTHNTICATION_ERROR = "AuthenticationError";
	public static final String REGISTRATION_ERROR = "RegistrationError";
	public static final String IS_REGISTRATION_COMPLITE ="isRegistrationComplite";
	public static final String PRESENTATION = "presentation";
	public static final String INDEX_JSP = "index.jsp";
	public static final String WRONG_LOGIN_OR_PASSWORD = "wrong login or password";
	public static final String ERROR_PAGE = "WEB-INF/pages/tiles/error.jsp";
	
	//GO_TO constants
	public static final String GO_TO_BASE_LAYOUT = "/WEB-INF/pages/layouts/baseLayout.jsp";
	public static final String GO_TO_BASE_PAGE = "controller?command=go_to_base_page";
	public static final String GO_TO_REGISTRATION_PAGE = "controller?command=go_to_registration_page";
	public static final String GO_TO_ERROR_PAGE = "controller?command=go_to_error_page";
	
}
