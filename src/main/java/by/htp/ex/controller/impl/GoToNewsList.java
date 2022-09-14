package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

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

public class GoToNewsList implements Command {

	private final static Logger LOG = LogManager.getLogger(GoToNewsList.class);

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> newsList;
		try {
			newsList = newsService.list();
			request.setAttribute(NewsConstant.NEWS, newsList);
			request.setAttribute(ControllerConstant.PRESENTATION, NewsConstant.NEWS_LIST);

			request.getRequestDispatcher(ControllerConstant.GO_TO_BASE_LAYOUT).forward(request, response);
		} catch (ServiceException e) {
			LOG.error(e);
			response.sendRedirect(ControllerConstant.GO_TO_ERROR_PAGE);
		}

	}

}
