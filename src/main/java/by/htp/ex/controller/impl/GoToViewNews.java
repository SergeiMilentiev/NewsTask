package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.constant.ControllerConstant;
import by.htp.ex.constant.NewsConstant;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToViewNews implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private final static Logger logger = LogManager.getLogger(GoToViewNews.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news;

		String id;

		id = request.getParameter(NewsConstant.NEWS_ID);

		try {
			news = newsService.findById(Integer.parseInt(id));
			request.setAttribute(NewsConstant.NEWS, news);
			request.setAttribute(ControllerConstant.PRESENTATION, NewsConstant.VIEW_NEWS);

			request.getRequestDispatcher(ControllerConstant.GO_TO_BASE_LAYOUT).forward(request, response);
		} catch (ServiceException e) {
			logger.log(Level.ERROR, e);
			response.sendRedirect(ControllerConstant.GO_TO_ERROR_PAGE);
		}

	}

}
