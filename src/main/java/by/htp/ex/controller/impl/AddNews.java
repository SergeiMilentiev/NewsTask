package by.htp.ex.controller.impl;

import java.io.IOException;
import java.time.LocalDate;

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

public class AddNews implements Command{

	private final static Logger LOG = LogManager.getLogger(AddNews.class);

	private final INewsService iNewsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter(NewsConstant.NEWS_TITLE);
		String briefNews = request.getParameter(NewsConstant.NEWS_BRIEF);
		String content = request.getParameter(NewsConstant.NEWS_CONTENT);
		LocalDate newsDate = LocalDate.now();

		News news = new News(title, briefNews, content, newsDate);
		
		request.getSession().removeAttribute(NewsConstant.NEWS_ADDED_STATUS);
		
		try {
			if (iNewsService.addNews(news)) {
				request.getSession().setAttribute(NewsConstant.NEWS_ADDED_STATUS, true);
				response.sendRedirect(NewsConstant.GO_TO_ADD_NEWS);
			} else {
				request.getSession().setAttribute(NewsConstant.NEWS_ADDED_STATUS, false);
				response.sendRedirect(NewsConstant.GO_TO_ADD_NEWS);
			}
		} catch (ServiceException e) {
			LOG.error(e);
			response.sendRedirect(ControllerConstant.GO_TO_ERROR_PAGE);
		}
		
	}
	
}
