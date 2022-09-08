package by.htp.ex.constant;

public class SQLConstant {

	// USER SQL REQUESTS
	public static final String LOGINATION_SQL_REQUEST = "SELECT * FROM users WHERE login=? AND password=?";
	public static final String REGISTRATION_SQL_REQUEST = "INSERT INTO users (name, surname, email, password, login) VALUES (?,?,?,?,?)";
	public static final String CHECK_USER_ECXISTS_SQL_REQUEST = "SELECT * FROM users WHERE login=? AND email=?";
	public static final String GET_USERS_ROLE_SQL_REQUEST = "SELECT role FROM users WHERE login=? AND password=?";

	// NEWS SQL REQUESTS
	public static final String GET_ALL_NEWS = "SELECT * FROM news";
	public static final String GET_LATEST_NEWS = "SELECT * FROM news ORDER BY id DESC LIMIT ?";
	public static final String FETCH_BY_ID_NEWS = "SELECT * FROM news WHERE id=?";
	public static final String ADD_NEWS = "INSERT INTO news(title, brief, content, newsDate) VALUES(?,?,?,?)";
	public static final String UPDATE_NEWS = "UPDATE news SET title=?, brief=?, content=?, newsDate=? WHERE id=?";
	public static final String DELETE_NEWS = "DELETE FROM news WHERE id=?";

}
