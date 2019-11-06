package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import util.ConnectDBNews;

public class CatDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM categories";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category objItem = new Category(id, name);
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
