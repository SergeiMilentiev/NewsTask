package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.connection.ConnectionPool;
import by.htp.ex.connection.ConnectionPoolException;
import by.htp.ex.constant.NewsConstant;
import by.htp.ex.constant.SQLConstant;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;

public class NewsDAO implements INewsDAO {

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> result = new ArrayList<News>();
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.GET_LATEST_NEWS)) {
			stmt.setInt(1, count);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				News news = new News(rs.getInt(NewsConstant.NEWS_ID), rs.getString(NewsConstant.NEWS_TITLE),
						rs.getString(NewsConstant.NEWS_BRIEF), rs.getString(NewsConstant.NEWS_CONTENT),
						rs.getDate(NewsConstant.NEWS_DATE).toLocalDate());
				result.add(news);
			}
			return result;
		} catch (SQLException | ConnectionPoolException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.GET_ALL_NEWS)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				News news = new News(rs.getInt(NewsConstant.NEWS_ID), rs.getString(NewsConstant.NEWS_TITLE),
						rs.getString(NewsConstant.NEWS_BRIEF), rs.getString(NewsConstant.NEWS_CONTENT),
						rs.getDate(NewsConstant.NEWS_DATE).toLocalDate());
				result.add(news);
			}

			return result;

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
		}
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.FETCH_BY_ID_NEWS)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();

			News news = new News(rs.getInt(NewsConstant.NEWS_ID), rs.getString(NewsConstant.NEWS_TITLE),
					rs.getString(NewsConstant.NEWS_BRIEF), rs.getString(NewsConstant.NEWS_CONTENT),
					rs.getDate(NewsConstant.NEWS_DATE).toLocalDate());
			System.out.println(news);
			return news;
		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		}
	}

	@Override
	public boolean addNews(News news) throws NewsDAOException {
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.ADD_NEWS)) {
			stmt.setString(1, news.getTitle());
			stmt.setString(2, news.getBriefNews());
			stmt.setString(3, news.getContent());
			stmt.setDate(4, Date.valueOf(news.getNewsDate()));
			stmt.execute();
			return true;
		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		}
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.UPDATE_NEWS)) {
			stmt.setString(1, news.getTitle());
			stmt.setString(2, news.getBriefNews());
			stmt.setString(3, news.getContent());
			stmt.setDate(4, Date.valueOf(news.getNewsDate()));
			stmt.setInt(5, news.getIdNews());

			stmt.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		}

	}

	@Override
	public void deleteNewses(int[] idNewses) throws NewsDAOException {
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement stmt = connection.prepareStatement(SQLConstant.DELETE_NEWS)) {
			for (int i : idNewses) {
				stmt.setInt(1, i);
				stmt.executeUpdate();
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
		}
	}

}
