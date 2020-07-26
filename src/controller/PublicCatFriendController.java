package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Friend;
import model.dao.CatDao;
import model.dao.FriendDao;

public class PublicCatFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatFriendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid = 0;
		try {
			cid = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/BT3/PageNotFound.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<Friend> listFriendsByIdCat = FriendDao.getItemsByIdCat(cid);
		request.setAttribute("listFriendsByIdCat", listFriendsByIdCat);

		RequestDispatcher rd = request.getRequestDispatcher("/BT3/danh-muc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
