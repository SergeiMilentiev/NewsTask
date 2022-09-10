package by.htp.ex.constant;

public class ValidationConstant {
	public static final String NAME_AND_SURNAME_REGEX = "^[а-яА-Я]{2,30}|[a-zA-Z]{2,30}";
	public static final String LOGIN_AND_PASSWORD_REGEX = "[\\w]{4,24}";
	public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";

	public static final String INVALID_NAME = "invalidName";
	public static final String INVALID_SURNAME = "invalidSurname";
	public static final String INVALID_LOGIN = "invalidLogin";
	public static final String INVALID_PASSWORD = "invalidPassword";
	public static final String INVALID_EMAIL = "invalidEmail";
}
