<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.bean.Users"%>
<!DOCTYPE HTML>
<html>
<head>
<title>CPANEL | VinaEnter Edu</title>
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
			<h2>TRANG QUẢN TRỊ VIÊN | CẬP NHẬT THÔNG TIN NGƯỜI DÙNG</h2>
			<div class="login-main login-agileits">
				<%
					if (request.getAttribute("msg") != null) {
						String msg = (String) request.getAttribute("msg");
						out.print("<p style='color: red'>" + msg + "</p>");
					}
					String email = "";
					String fullname = "";
					if (request.getAttribute("email") != null) {
						email = (String) request.getAttribute("email");
					}
					if (request.getAttribute("fullname") != null) {
						fullname = (String) request.getAttribute("fullname");
					}
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
				<div class="userinfo" style="margin-bottom: 20px;">
					<p class="fullname">
						Xin chào :
						<%
						out.print(name);
					%>
					</p>
					<p class="link">
						<a href="<%=request.getContextPath()%>/logout" title="Đăng xuất">Đăng
							xuất</a>
					</p>
				</div>

				<form method="post" enctype="multipart/form-data">
					<table class="update-user" border="1" width="500px" align="center">
						<tr align="center">
							<th>Email</th>
							<td><input type="text" value="<%if(email!="") out.print(email);%>" name="email" class="input-u" /></td>
						</tr>

						<tr align="center">
							<th>Fullname</th>
							<td><input type="text" value="<%if(fullname!="") out.print(fullname);%>" name="fullname"
								class="input-u" /></td>
						</tr>

						<tr align="center">
							<th>Avatar</th>
							<td><input type="file" value="Upload file" name="avatar"
								class="input-u" /></td>
						</tr>

						<tr align="center">
							<td></td>
							<td>
								<button>Cập nhật thông tin</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>