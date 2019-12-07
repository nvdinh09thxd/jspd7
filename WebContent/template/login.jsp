<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script
	src="<%=request.getContextPath()%>/template/js/jquery-3.3.1.min.js"></script>
<script
	src="<%=request.getContextPath()%>/template/js/jquery.validate.min.js"></script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<!-- login starts here -->
	<div class="login agile">
		<div class="w3agile-border">
			<h2>Login Form | VinaEnter Edu</h2>
			<div class="login-main login-agileits">
				<%
					if (request.getAttribute("err") != null) {
						String err = (String) request.getAttribute("err");
						out.print("<p style='color: red'>" + err + "</p>");
					}
					String email = "";
					if (request.getAttribute("email") != null) {
						email = (String) request.getAttribute("email");
					}
				%>
				<h1>Login</h1>
				<form method="post">
					<p>Email (*)</p>
					<input type="text" placeholder="example@gmail.com" name="email"
						value="<%if (email != "") out.print(email);%>">
					<p>Password (*)</p>
					<input type="password" placeholder="Password" name="password">

					<input type="submit" value="Login">
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('form').validate({
			rules : {
				"email" : {
					required : true,
				},
				"password" : {
					required : true,
				},
			},
			messages : {
				"email" : {
					required : "Yeu cau nhap!",
				},
				"password" : {
					required : "Yeu cau nhap!",
				},
			},
		});
	</script>
</body>
</html>