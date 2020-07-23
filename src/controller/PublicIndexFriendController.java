package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Friend;
import model.dao.FriendDao;

public class PublicIndexFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicIndexFriendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Friend> listFriends = FriendDao.getItems();
		request.setAttribute("listFriends", listFriends);
		RequestDispatcher rd = request.getRequestDispatcher("/BT3/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
