package by.htp.ex.util.validation;

import java.util.Map;

import by.htp.ex.bean.NewUserInfo;

public interface UserDataValidation {
	boolean checkAuthData(String login, String password);

	boolean checkRegData(NewUserInfo user);

	public Map<String, Boolean> getInvalidData();
}
