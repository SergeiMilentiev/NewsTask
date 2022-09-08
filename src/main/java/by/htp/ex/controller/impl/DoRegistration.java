package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.constant.UserConstant;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final static Logger LOG = LogManager.getLogger(DoRegistration.class);

	private final IUserService service = ServiceProvider.getInstance().getUserService();
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NewUserInfo newUser = new NewUserInfo();

		String firstName = request.getParameter(UserConstant.NAME);
		String lastName = request.getParameter(UserConstant.SURNAME);
		String email = request.getParameter(UserConstant.EMAIL);
		String login = request.getParameter(UserConstant.LOGIN);
		String password = request.getParameter(UserConstant.PASSWORD);

		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setLogin(login);

		try {
			boolean isRegistrationComplite = service.registration(newUser);

			if (isRegistrationComplite) {
				request.getSession(true).setAttribute("user", "not active");
				request.getSession().setAttribute("role", "user");
				response.sendRedirect("controller?command=GO_TO_BASE_PAGE");
			} else {
				List<String> invalidData = userDataValidation.getInvalidData();
				request.getSession(true).setAttribute("user", "not active");
				request.setAttribute("RegistrationError", invalidData);
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			LOG.error(e);
		}
	}

}
