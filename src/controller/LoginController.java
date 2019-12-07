package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Users;
import model.dao.UserDao;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String err = "Sai tên đăng nhập hoặc mật khẩu";
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		ArrayList<Users> listItems = new ArrayList<>();
		UserDao userDao = new UserDao();
		listItems = userDao.getItems();
		for (Users user : listItems) {
//			nếu có user này trong csdl thì cho phép đăng nhập
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("listUsers", listItems);
//				chuyển hướng sang trang index
				response.sendRedirect(request.getContextPath() + "/template/index.jsp");
				return;
			}
		}
		if(!"".equals(email)) {
			request.setAttribute("email", email);
		}
		request.setAttribute("email", email);
		request.setAttribute("err", err);
//		chuyển tiếp sang trang login
		RequestDispatcher rd = request.getRequestDispatcher("/template/login.jsp");
		rd.forward(request, response);
	}
}