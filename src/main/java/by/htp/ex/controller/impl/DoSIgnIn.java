package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.constant.ControllerConstant;
import by.htp.ex.constant.UserConstant;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSIgnIn implements Command {

	private final static Logger LOG = LogManager.getLogger(DoSIgnIn.class);

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;

		login = request.getParameter(UserConstant.LOGIN);
		password = request.getParameter(UserConstant.PASSWORD);

		try {

			String role = service.signIn(login, password);

			if (!role.equals(UserConstant.GUEST_ROLE)) {
				request.getSession(true).setAttribute(UserConstant.USER_ROLE, ControllerConstant.ACTIVE);
				request.getSession(true).setAttribute(UserConstant.ROLE, role);
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				request.getSession(true).setAttribute(UserConstant.USER_ROLE, ControllerConstant.NOT_ACTIVE);
				request.setAttribute("AuthenticationError", "wrong login or password");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			}

		} catch (ServiceException e) {
			LOG.error(e);
		}
	}
}
