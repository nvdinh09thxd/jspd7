package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Users;
import model.dao.UserDao;

@MultipartConfig
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateController() {
		super();
	}

	public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/capnhat.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg0 = "Vui long nhap day du thong tin!";
		String msg1 = "Cap nhat thanh cong!";
		String msg2 = "Cap nhat that bai!";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		if ("".equals(email) || "".equals(fullname)) {
			request.setAttribute("msg", msg0);
			if(!"".equals(email)) {
				request.setAttribute("email", email);
			}
			if(!"".equals(fullname)) {
				request.setAttribute("fullname", fullname);
			}
			forward(request, response);
			return;
		}
		Part filePart = request.getPart("avatar");
		String fileName = filePart.getSubmittedFileName();
		Users userNew = null;
		UserDao userDao = new UserDao();
		Users user = userDao.getItem(id);
		String avatarName = user.getAvatar();
		if (!"".equals(fileName)) {
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + "avatar";
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			String portal = fileName.split("\\.")[0];
			String extra = fileName.split("\\.")[1];
			long time = System.currentTimeMillis();
			fileName = portal + "_" + time + "." + extra;
			String avatarPath = dirPath + File.separator + avatarName;
			File file = new File(avatarPath);
			file.delete();
			String filePath = dirPath + File.separator + fileName;
			filePart.write(filePath);
			userNew = new Users(id, email, "", fileName, fullname);
		} else {
			userNew = new Users(id, email, "", avatarName, fullname);
		}
		if (userDao.editItem(userNew) > 0) {
			HttpSession session = request.getSession();
			request.setAttribute("msg", msg1);
			session.setAttribute("user", userNew);
			@SuppressWarnings("unchecked")
			ArrayList<Users> listUsers = (ArrayList<Users>) session.getAttribute("listUsers");
			
			for(int i = 0; i < listUsers.size(); i++) {
			    if(i==id-1) {
			    	listUsers.set(i, userNew);
			    }
			}
			RequestDispatcher rd = request.getRequestDispatcher("/template/index.jsp");
			rd.forward(request, response);
			return;
		} else {
			request.setAttribute("msg", msg2);
			forward(request, response);
			return;
		}
	}
}