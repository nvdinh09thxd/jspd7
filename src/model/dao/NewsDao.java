package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.News;
import util.ConnectDBNews;

public class NewsDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static ArrayList<News> getItems() {
		ArrayList<News> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM news";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				News objItem = new News(id, name, description);
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, st, conn);
		}
		return listItems;
	}	
}
