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

public class PublicDetailFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicDetailFriendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int did = 0;
		try {
			did = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/BT3/PageNotFound.jsp");
			rd.forward(request, response);
			return;
		}
			Friend itemFriend = FriendDao.getItem(did);
			ArrayList<Friend> listRelatedFriends = FriendDao.getRelatedFriends(did);
			request.setAttribute("itemFriend", itemFriend);
			request.setAttribute("listRelatedFriends", listRelatedFriends);

			RequestDispatcher rd = request.getRequestDispatcher("/BT3/chi-tiet.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
