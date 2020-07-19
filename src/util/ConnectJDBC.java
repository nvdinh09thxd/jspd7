package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// Nạp driver
			Class.forName("com.mysql.jdbc.Driver");
			// Tạo connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tintuc?useUnicode=true&characterEncoding=UTF-8", "root", "");
			System.out.println("Connection: " + conn);
			// Lấy danh sách các danh mục tin
			final String SQL_GET_ALL = "SELECT ID_DanhMucTin, TenDanhMucTin AS Ten FROM danhmuctin";
			// Thực thi truy vấn
			st = conn.createStatement();
			rs = st.executeQuery(SQL_GET_ALL);
			while (rs.next()) {
				// Lấy dữ liệu trả về từ câu lệnh truy vấn
				int catId = rs.getInt("ID_DanhMucTin");
				String catName = rs.getString("Ten");
				System.out.println("catId: " + catId + " --- catName: " + catName);
				System.out.println("---------------------------------------------");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
