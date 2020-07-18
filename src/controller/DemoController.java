package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DemoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// nạp driver
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/tintuc?useUnicode=yes&characterEncoding=UTF-8";
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			// hiển thị danh sách các danh mục
			String sql = "SELECT * FROM danhmuctin";
			String sqlInsert = "INSERT INTO danhmuctin (tendanhmuctin) VALUES (?)";
			ArrayList<String> arData = new ArrayList<>();
			arData.add("Tin thời sự");
			arData.add("Tin thế giới");
			arData.add("Tin Việt Nam");
			st = conn.createStatement();
			pst = conn.prepareStatement(sqlInsert);
			int n = 0;//insertData(pst, arData);
			if (n > 0)
				System.out.println("Đã thêm vào thành công " + n + " tin!");
			rs = selectData(st, sql);
			displayData(rs, out);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public int insertData(PreparedStatement pst, ArrayList<String> arData) {
		int results = 0;
		for (String obj : arData) {
			try {
				pst.setString(1, obj);
				pst.executeUpdate();
				results++;
			} catch (SQLException e) {
			}
		}
		return results;
	}

	public ResultSet selectData(Statement st, String sql) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public void displayData(ResultSet rs, PrintWriter out) {
		try {
			while (rs.next()) {
				int idDanhMuc = rs.getInt("id_danhmuctin");
				String tenDanhMuc = rs.getString("tendanhmuctin");
				out.println("ID danh muc: " + idDanhMuc + "<br />");
				out.println("Tên danh muc: " + tenDanhMuc + "<br />");
				out.println("----------------------------<br />");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
