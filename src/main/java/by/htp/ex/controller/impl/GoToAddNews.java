package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.constant.NewsConstant;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAddNews implements Command {

	private final static Logger LOG = LogManager.getLogger(GoToAddNews.class);

	private final INewsService iNewsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter(NewsConstant.NEWS_TITLE);
		String briefNews = request.getParameter(NewsConstant.NEWS_BRIEF);
		String content = request.getParameter(NewsConstant.NEWS_CONTENT);
		String newsDate = request.getParameter(NewsConstant.NEWS_DATE);

		News news = new News(title, briefNews, content, newsDate);

		try {
			if (iNewsService.addNews(news)) {
				request.getSession(true).setAttribute("news_added_status", "news added");
				response.sendRedirect(NewsConstant.GO_TO_NEWS_LIST);
			} else {
				request.getSession(true).setAttribute("news_added_status", "news not added");
				response.sendRedirect(NewsConstant.GO_TO_ADD_NEWS);
			}
		} catch (ServiceException e) {
			LOG.error(e);
		}
	}

}
