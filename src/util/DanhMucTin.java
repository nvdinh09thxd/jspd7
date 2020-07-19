package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DanhMucTin {

	public static void main(String[] args) {
		// Lấy danh mục tin có id = 3
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// Tạo connection
			conn = JDBCConnectionUtil.getConnection();
			// System.out.println("Connection: " + conn);
			// Lấy danh sách các danh mục tin
			final String SQL_SELECT_ID_3 = "SELECT ID_DanhMucTin, TenDanhMucTin FROM danhmuctin WHERE ID_DanhMucTin = 3";
			// Thực thi truy vấn
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ID_3);
			if (rs.next()) {
				// Lấy dữ liệu trả về từ câu lệnh truy vấn
				int catId = rs.getInt("ID_DanhMucTin");
				String catName = rs.getString("TenDanhMucTin");
				System.out.println("catId: " + catId + " --- catName: " + catName);
				System.out.println("---------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, st, conn);
		}

	}

}
