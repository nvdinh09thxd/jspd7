<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/BT3/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
			 <%
			 	int cid = Integer.parseInt(request.getParameter("cid"));
		 		Category itemCat = CatDao.getFriendListById(cid);
			 	if(itemCat != null){
			 %>				 
				 <h1 class="title"><span>Những người bạn >> </span><%=itemCat.getName() %></h1>
				 <%}
			 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 	@SuppressWarnings("unchecked")
					ArrayList<Friend> listFriendsByIdCat = (ArrayList<Friend>) request.getAttribute("listFriendsByIdCat");
						if (listFriendsByIdCat != null && listFriendsByIdCat.size() > 0) {
								for (Friend item : listFriendsByIdCat) {
				 %>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath()%>/friend/detail?did=<%=item.getId()%>"><%=item.getName() %></a></h3>
							 <h4>Đăng ngày: <%=sdf.format(item.getDateCreate()) %> - Lượt xem: <%=item.getCountNumber() %></h4>
							 <p><%=item.getPreview() %></p>
							 <img src="<%=request.getContextPath() %>/BT3/images/<%=item.getPicture() %>" alt="<%=item.getPicture() %>"/>
							 <a class="bttn" href="<%=request.getContextPath()%>/friend/detail?did=<%=item.getId()%>">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				 <%}}else {%>	
				 	<p>Danh sách trống</p>
				<%}%>	 
			 </div>
				 <%@include file="/BT3/inc/right-bar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<script>
	<%if(itemCat!=null){%>
    	document.getElementById("<%=itemCat.getId()%>").classList.add('active');
	<%}%>
    document.getElementById("index").classList.add('active');
</script>
<%@include file="/BT3/inc/footer.jsp" %>