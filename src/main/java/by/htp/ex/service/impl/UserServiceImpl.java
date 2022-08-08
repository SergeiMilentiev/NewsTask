package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.connection.ConnectionPoolException;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();

	@Override
	public String signIn(String login, String password) throws ServiceException {

		try {
			if (userDAO.logination(login, password)) {
				return userDAO.getRole(login, password);
			} else {
				return "guest";
			}

		} catch (DaoException | ConnectionPoolException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {
		try {
			if (userDAO.registration(user)) {
				System.out.println("true on service");
				return true;
			} else {
				return false;
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
