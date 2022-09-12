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

public class EditNews implements Command{

	private final static Logger LOG = LogManager.getLogger(EditNews.class);

	private final INewsService iNewsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter(NewsConstant.NEWS_ID));
		String title = request.getParameter(NewsConstant.NEWS_TITLE);
		String brief = request.getParameter(NewsConstant.NEWS_BRIEF);
		String content = request.getParameter(NewsConstant.NEWS_CONTENT);
		LocalDate date = LocalDate.now();
		News news = new News(id, title, brief, content, date);
		try {
			iNewsService.update(news);
			response.sendRedirect(NewsConstant.GO_TO_NEWS_LIST);
		} catch (ServiceException e) {
			LOG.error(e);
			response.sendRedirect(ControllerConstant.GO_TO_ERROR_PAGE);
		}
	}

}
