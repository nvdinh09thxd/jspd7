package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Contact;
import util.ConnectDBMyFriends;

public class ContactDao {
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	public static int addItem(Contact item) {
		int result = 0;
		conn = ConnectDBMyFriends.getConnection();
		String sql = "INSERT INTO contact (name, email, phone, content) VALUES (?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, item.getName());
			pst.setString(2, item.getEmail());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getMessage());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBMyFriends.close(rs, pst, conn);
		}

		return result;
	}

}
