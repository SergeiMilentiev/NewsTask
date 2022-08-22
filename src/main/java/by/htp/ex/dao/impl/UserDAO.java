package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.connection.ConnectionPool;
import by.htp.ex.connection.ConnectionPoolException;
import by.htp.ex.constant.DAOConstant;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;

public class UserDAO implements IUserDAO {

	ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean logination(String login, String password) throws DaoException {
		NewUserInfo newUser = new NewUserInfo();
		try (final Connection connection = connectionPool.takeConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DAOConstant.LOGINATION_SQL_REQUEST);
			stmt.setString(1, newUser.getLogin());
			stmt.setString(2, newUser.getPassword());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString(DAOConstant.NAME);
				String lastName = rs.getString(DAOConstant.SURNAME);
				String dateOfBirth = rs.getString(DAOConstant.DATE_OF_BIRTH);
				String email = rs.getString(DAOConstant.EMAIL);
				newUser.setFirstName(firstName);
				newUser.setLastName(lastName);
				newUser.setDateOfBirth(dateOfBirth);
				newUser.setEmail(email);
				return true;
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public String getRole(String login, String password) {
		return DAOConstant.USER;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {
		try (final Connection connection = connectionPool.takeConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DAOConstant.REGISTRATION_SQL_REQUEST);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getDateOfBirth());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getLogin());
			stmt.execute();
			return true;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean checkUserEcxists(String login, String email) throws DaoException {
		try (final Connection connection = connectionPool.takeConnection();
				PreparedStatement stmt = connection.prepareStatement(DAOConstant.CHECK_USER_ECXISTS_SQL_REQUEST)) {
			stmt.setString(1, login);
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		}
	}
}
