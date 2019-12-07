<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.Users"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Form User | VinaEnter Edu</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link href="<%=request.getContextPath()%>/template/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- login starts here -->
	<div class="login agile">
		<div class="w3agile-border">
			<h2>Trang quản trị viên | VinaEnter Edu</h2>
			<div class="login-main login-agileits">
				<%
					String name = "";
					int id = 0;
					if (session.getAttribute("user") != null) {
						Users user = (Users) session.getAttribute("user");
						name = user.getFullName();
						id = user.getId();
					} else {
						response.sendRedirect(request.getContextPath() + "/login");
					}
				%>
				<div class="userinfo">
					<p class="fullname">
						Xin chào :
						<%
						out.print(name);
					%>
					</p>
					<p class="link">
						<a href="<%=request.getContextPath()%>/update?id=<%=id%>"
							title="Cập nhật thông tin">Cập nhật thông tin</a>
					</p>
					<p class="link">
						<a href="<%=request.getContextPath()%>/logout"
							title="Đăng xuất">Đăng xuất</a>
					</p>
				</div>
				<h1>Danh sách người dùng</h1>
				<%
					if (request.getAttribute("msg") != null) {
						String msg = (String) request.getAttribute("msg");
						out.print("<p style='color: green'>" + msg + "</p>");
					}
				%>
				<table class="index-user" border="1" width="500px" align="center">
					<tr align="center">
						<th>Id</th>
						<th>Email</th>
						<th>Avatar</th>
						<th>Full name</th>
					</tr>
					<%
						@SuppressWarnings("unchecked")
						ArrayList<Users> listUsers = (ArrayList<Users>) session.getAttribute("listUsers");
						if (listUsers != null && listUsers.size() > 0) {
							for (Users objUsers : listUsers) {
					%>
					<tr align="center">
						<td><%=objUsers.getId()%></td>
						<td><%=objUsers.getEmail()%></td>
						<td><img
							src="<%=request.getContextPath()%>/avatar/<%=objUsers.getAvatar()%>"
							alt="" width="100px" height="100px" /></td>
						<td><%=objUsers.getFullName()%></td>
					</tr>
					<%
						}
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>