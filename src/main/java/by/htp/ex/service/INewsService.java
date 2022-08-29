package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface INewsService {
	boolean addNews(News news) throws ServiceException;

	void deleteNews(int[] idNews) throws ServiceException;

	void update(News news) throws ServiceException;

	List<News> latestList(int count) throws ServiceException;

	List<News> list() throws ServiceException;

	News findById(int id) throws ServiceException;
}
