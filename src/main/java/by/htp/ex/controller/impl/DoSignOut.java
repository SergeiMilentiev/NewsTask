package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.constant.ControllerConstant;
import by.htp.ex.constant.UserConstant;
import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignOut implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).invalidate();
		request.getSession(true).setAttribute(UserConstant.USER_ROLE, ControllerConstant.NOT_ACTIVE);
		response.sendRedirect(ControllerConstant.INDEX_JSP);
	}

}
