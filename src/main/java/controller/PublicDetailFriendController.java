package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Friend;
import dao.FriendDao;

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
			//Lấy chi tiết bạn bè theo id
			Friend itemFriend = FriendDao.getItem(did);
			if (itemFriend == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/BT3/PageNotFound.jsp");
				rd.forward(request, response);
				return;
			}
			//Lấy danh sách bạn bè liên quan (là những bạn có chung id_cat nhưng khác bạn bè đang xem)
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
