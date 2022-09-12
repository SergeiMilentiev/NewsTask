package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.constant.ControllerConstant;
import by.htp.ex.constant.NewsConstant;
import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAddNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(NewsConstant.NEWS_ADD_STATUS, NewsConstant.ADD_NEWS);
		request.getRequestDispatcher(ControllerConstant.GO_TO_BASE_LAYOUT).forward(request, response);
	}

}
