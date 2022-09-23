package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDBMyFriends {
	private static Connection conn;
	private static final String username = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/myfriends1?useUnicode=yes&characterEncoding=UTF-8";

	public static Connection getConnection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(PreparedStatement pst) {
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}

	public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
		close(rs);
		close(pst);
		close(conn);
	}
}
