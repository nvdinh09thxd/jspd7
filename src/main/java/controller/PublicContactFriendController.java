package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contact;
import dao.ContactDao;

public class PublicContactFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicContactFriendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/BT3/lien-he.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		Contact contact = new Contact(0, name, email, phone, message);
		if (ContactDao.addItem(contact) > 0) {
			response.sendRedirect(request.getContextPath() + "/BT3/lien-he.jsp?msg=1");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/BT3/lien-he.jsp?msg=0");
			rd.forward(request, response);
		}
	}

}
