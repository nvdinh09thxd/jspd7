package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.ConnectDBMyFriends;
import model.bean.Category;
import model.bean.Friend;

public class FriendDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public static ArrayList<Friend> getItems() {
		ArrayList<Friend> listItems = new ArrayList<>();
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friends as f JOIN friend_list as fl ON f.fl_id=fl.fl_id";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("fid");
				String name = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				Timestamp dateCreate = rs.getTimestamp("date_create");
				int countNumber = rs.getInt("count_number");
				String picture = rs.getString("picture");
				Category fl = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
				Friend objItem = new Friend(id, name, preview, detail, dateCreate, countNumber, picture, fl);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, st, conn);
		}
		return listItems;
	}

	public static ArrayList<Friend> getItemsByIdCat(int cid) {
		ArrayList<Friend> listItems = new ArrayList<>();
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friends as f JOIN friend_list as fl ON f.fl_id=fl.fl_id WHERE fl.fl_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("fid");
				String name = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				Timestamp dateCreate = rs.getTimestamp("date_create");
				int countNumber = rs.getInt("count_number");
				String picture = rs.getString("picture");
				Category fl = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
				Friend objItem = new Friend(id, name, preview, detail, dateCreate, countNumber, picture, fl);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}
		return listItems;
	}

	public static Friend getItem(int did) {
		Friend item = null;
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friends as f JOIN friend_list as fl ON f.fl_id=fl.fl_id WHERE f.fid = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("fid");
				String name = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				Timestamp dateCreate = rs.getTimestamp("date_create");
				int countNumber = rs.getInt("count_number");
				String picture = rs.getString("picture");
				Category fl = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
				item = new Friend(id, name, preview, detail, dateCreate, countNumber, picture, fl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}
		return item;
	}

	public static ArrayList<Friend> getRelatedFriends(int did) {
		ArrayList<Friend> listItems = new ArrayList<>();
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friends as f JOIN friend_list as fl ON f.fl_id=fl.fl_id WHERE f.fl_id="
					+ "(SELECT fl_id FROM friends WHERE fid = ?) AND f.fid != ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			pst.setInt(2, did);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("fid");
				String name = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				Timestamp dateCreate = rs.getTimestamp("date_create");
				int countNumber = rs.getInt("count_number");
				String picture = rs.getString("picture");
				Category fl = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
				Friend objItem = new Friend(id, name, preview, detail, dateCreate, countNumber, picture, fl);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}
		return listItems;
	}

	public static ArrayList<Friend> getItems(String fname) {
		ArrayList<Friend> listItems = new ArrayList<>();
		conn = ConnectDBMyFriends.getConnection();
		try {
			String sql = "SELECT * FROM friends as f JOIN friend_list as fl ON f.fl_id=fl.fl_id WHERE f.fname LIKE ?";
			pst = conn.prepareStatement(sql);
			String a = "%" + fname + "%";
			pst.setString(1, a);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("fid");
				String name = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				Timestamp dateCreate = rs.getTimestamp("date_create");
				int countNumber = rs.getInt("count_number");
				String picture = rs.getString("picture");
				Category fl = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
				Friend objItem = new Friend(id, name, preview, detail, dateCreate, countNumber, picture, fl);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}
		return listItems;
	}

}
