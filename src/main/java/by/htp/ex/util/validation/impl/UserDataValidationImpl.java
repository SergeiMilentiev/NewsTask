package by.htp.ex.util.validation.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.constant.ValidationConstant;
import by.htp.ex.util.validation.UserDataValidation;

public class UserDataValidationImpl implements UserDataValidation {

	private Map <String, Boolean> invalidData = new HashMap<String, Boolean>();

	@Override
	public boolean checkAuthData(String login, String password) {
		return false;
	}

	@Override
	public boolean checkRegData(NewUserInfo user) {

		if (!checkingNameOrSurname(user.getFirstName())) {
			invalidData.put(ValidationConstant.INVALID_NAME, false);
		}
		if (!checkingNameOrSurname(user.getLastName())) {
			invalidData.put(ValidationConstant.INVALID_SURNAME, false);
		}
		if (!checkingLoginOrPassword(user.getLogin())) {
			invalidData.put(ValidationConstant.INVALID_LOGIN, false);
		}
		if (!checkingLoginOrPassword(user.getPassword())) {
			invalidData.put(ValidationConstant.INVALID_PASSWORD, false);
		}
		if (!checkingEmail(user.getEmail())) {
			invalidData.put(ValidationConstant.INVALID_EMAIL, false);
		}

		return checkingNameOrSurname(user.getFirstName()) && checkingNameOrSurname(user.getLastName())
				&& checkingLoginOrPassword(user.getLogin()) && checkingLoginOrPassword(user.getPassword())
				&& checkingEmail(user.getEmail());
	}

	private boolean checkingNameOrSurname(String data) {
		return Pattern.compile(ValidationConstant.NAME_AND_SURNAME_REGEX).matcher(data).matches();
	}

	private boolean checkingLoginOrPassword(String data) {
		return Pattern.compile(ValidationConstant.LOGIN_AND_PASSWORD_REGEX).matcher(data).matches();
	}

	private boolean checkingEmail(String email) {
		return Pattern.compile(ValidationConstant.EMAIL_REGEX).matcher(email).matches();
	}

	@Override
	public Map<String, Boolean> getInvalidData() {
		return invalidData;
	}
}
