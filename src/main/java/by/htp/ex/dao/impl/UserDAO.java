package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.connection.AbstractConnection;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;

public class UserDAO implements IUserDAO{

	@Override
	public boolean logination(String login, String password) throws DaoException {
		NewUserInfo newUser = new NewUserInfo();
		try(final Connection connection = AbstractConnection.connection()){
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
            stmt.setString(1, newUser.getEmail());
            stmt.setString(2, newUser.getPassword());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String dateOfBirth = rs.getString("dateOfBirth");
                String email = rs.getString("email");
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setDateOfBirth(dateOfBirth);
                newUser.setEmail(email);
                return true;
            }
    } catch (SQLException e){
        throw new DaoException("Не удалось найти пользователя", e);
    }
		return false;
    }
//		return true;
//	}
	
	public String getRole(String login, String password) {
		return "user";
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {
//	        try ( final Connection connection = AbstractConnection.connection()){
//	           PreparedStatement stmt = connection.prepareStatement(INSERT INTO user (firstName, lastName, dateOfBirth, email, password) VALUES (?,?,?,?,?));
//				stmt.setString(1, user.getFirstName());
//				stmt.setString(2, user.getLastName());
//				stmt.setString(3, user.getDateOfBirth());
//		        stmt.setString(4, user.getEmail());
//		        stmt.setString(5, user.getPassword());
//				stmt.execute();
//	            return true;
//	        } catch (SQLException e){
//	            throw new DaoException("Не удалось создать пользователя", e);
//	        }
		return true;
	}

}
