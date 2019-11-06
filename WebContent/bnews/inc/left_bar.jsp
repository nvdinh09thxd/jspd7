<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Danh mục tin</h3>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Category> listCats = (ArrayList<Category>) request.getAttribute("listCats");
	if (listCats != null && listCats.size() > 0) {
%>
<ul>
	<%
		for (Category objCats : listCats) {
	%>
	<li><a href="cat.php" title=""><%=objCats.getName()%></a></li>
	<%
		}
	%>
</ul>
<%
	}
%>