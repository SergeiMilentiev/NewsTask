package by.htp.ex.util.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.constant.ValidationConstant;
import by.htp.ex.util.validation.UserDataValidation;

public class UserDataValidationImpl implements UserDataValidation {

	private List<String> invalidData = new ArrayList<String>();

	@Override
	public boolean checkAuthData(String login, String password) {
		return false;
	}

	@Override
	public boolean checkRegData(NewUserInfo user) {

		if (!checkingNameOrSurname(user.getFirstName())) {
			System.out.println("неверное имя");
			invalidData.add(ValidationConstant.INVALID_NAME);
		}
		if (!checkingNameOrSurname(user.getLastName())) {
			System.out.println("неверная фамилия");
			invalidData.add(ValidationConstant.INVALID_SURNAME);
		}
		if (!checkingLoginOrPassword(user.getLogin())) {
			System.out.println("неверный логин");
			invalidData.add(ValidationConstant.INVALID_LOGIN);
		}
		if (!checkingLoginOrPassword(user.getPassword())) {
			System.out.println("неверный пароль");
			invalidData.add(ValidationConstant.INVALID_PASSWORD);
		}
		if (!checkingEmail(user.getEmail())) {
			System.out.println("неверный email");
			invalidData.add(ValidationConstant.INVALID_EMAIL);
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
	public List<String> getInvalidData() {
		return invalidData;
	}
}
