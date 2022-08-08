package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.connection.ConnectionPoolException;

public interface IUserDAO {

	boolean logination(String login, String password) throws DaoException, ConnectionPoolException;

	boolean registration(NewUserInfo user) throws DaoException;

	public String getRole(String login, String password) throws DaoException;

}
