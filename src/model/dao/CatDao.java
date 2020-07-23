package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import util.ConnectDBMyFriends;
import util.ConnectDBNews;

public class CatDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public static ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM category";
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

	public static Category getItem(int idCat) {
		Category item = null;
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM category WHERE id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				item = new Category(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, pst, conn);
		}
		return item;
	}

	public static ArrayList<Category> getFriendList() {
		ArrayList<Category> listItems = new ArrayList<>();
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friend_list";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("fl_id");
				String name = rs.getString("fl_name");
				Category objItem = new Category(id, name);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, st, conn);
		}
		return listItems;
	}

	public static Category getFriendList(int idCat) {
		Category items = null;
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friend_list WHERE fl_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("fl_id");
				String name = rs.getString("fl_name");
				items = new Category(id, name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}
		return items;
	}

}
