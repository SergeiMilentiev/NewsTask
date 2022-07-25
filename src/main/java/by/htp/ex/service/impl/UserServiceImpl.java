package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService{

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	
	@Override
	public String signIn(String login, String password) throws ServiceException {
		
		try {
			if(userDAO.logination(login, password)) {
				return userDAO.getRole(login, password);
			}else {
				return "guest";
			}
			
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {	
		try {
			if(userDAO.registration(user)) {
				return true;
			} else {
				return false;
			}
		}catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}