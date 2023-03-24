<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Category"%>
<%@ page import="dao.CatDao"%>
<div class="col-md-4 content-main-right">
	<div class="search">
		 <h3>TÌM BẠN TÔI</h3>
		<form action="<%=request.getContextPath()%>/friend/search" method="post">
			<input type="text" placeholder="Nhập tên cần tìm" name="name" />
			<input type="submit" value="" />
		</form>
	</div>
	<div class="categories">
		 <h3>DANH MỤC BẠN BÈ</h3>
		 <%
		 	ArrayList<Category> friendList = CatDao.getFriendList();
			if (friendList.size() > 0) {
		 %>
		 <ul>
			<%for (Category item : friendList) { %>
			 <li id="<%=item.getId()%>"><a href="<%=request.getContextPath()%>/friend/cat?cid=<%=item.getId()%>"><%=item.getName() %></a></li>
			 <%}%>
		 </ul>
		 <%}else{ %>
			<p>Không có danh mục</p>
		<%} %>
	</div>
	<div class="archives">
		 <h3>Liên kết VinaEnter</h3>
		 <li class="active"><a href="http://vinaenter.edu.vn/lap-trinh-php-tu-az.html" target="_blank"><img width="100%" src="<%=request.getContextPath() %>/BT3/images/php.png" alt="" /></a></li>
		 <li><a href="http://vinaenter.edu.vn/lap-trinh-java-tu-az.html" target="_blank"><img width="100%" src="<%=request.getContextPath() %>/BT3/images/java.png" alt="" /></a></li>
		 <li><a href="http://vinaenter.edu.vn/lap-trinh-android-tu-az.html" target="_blank"><img width="100%" src="<%=request.getContextPath() %>/BT3/images/android.png" alt="" /></a></li>
	</div>
</div>