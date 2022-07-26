package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.constant.ControllerConstant;
import by.htp.ex.constant.NewsConstant;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteNews implements Command{

	private final static Logger LOG = LogManager.getLogger(DeleteNews.class);

	private final INewsService iNewsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] idNews = request.getParameterValues(NewsConstant.NEWS_ID);
		
		try {
			iNewsService.deleteNews(StringToInt(idNews));
			response.sendRedirect(NewsConstant.GO_TO_NEWS_LIST);
		} catch (ServiceException e) {
			LOG.error(e);
			response.sendRedirect(ControllerConstant.GO_TO_ERROR_PAGE);
		}
	}
	
	private int[] StringToInt (String[] stringArray) {
		int[] array = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; i++) {
			array[i] = Integer.parseInt(stringArray[i]);
			System.out.println(array[i]);
		}
		return array;
	}

}
