package by.htp.ex.constant;

public class DAOConstant {
	public static final String LOGINATION_SQL_REQUEST = "SELECT * FROM users WHERE login=? AND password=?";
	public static final String REGISTRATION_SQL_REQUEST = "INSERT INTO users (name, surname, dateOfBirth, email, password, login) VALUES (?,?,?,?,?,?)";
	public static final String CHECK_USER_ECXISTS_SQL_REQUEST = "SELECT * FROM users WHERE login=? AND email=?";

	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String EMAIL = "email";

	public static final String USER = "user";
	public static final String ADMIN = "admin";

}
