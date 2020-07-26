<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/BT3/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
				 <%
				 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					 Friend itemFriend = (Friend) request.getAttribute("itemFriend");
					 	if (itemFriend != null) {
				 %>
					 <div class="content-grid-head">
						 <h3><a href="<%=request.getContextPath()%>/friend/cat?cid=<%=itemFriend.getFl().getId()%>" title=""><%=itemFriend.getFl().getName() %></a></h3>
						 <h4>Đăng ngày: <%=sdf.format(itemFriend.getDateCreate()) %> - Lượt xem: <%=itemFriend.getCountNumber() %></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3><%=itemFriend.getName() %></h3>
						 <div class="detail_text">
							 <span><%=itemFriend.getPreview() %></span>
							 <img class="single-pic" src="<%=request.getContextPath() %>/BT3/images/<%=itemFriend.getPicture() %>" alt="">
							 <p><%=itemFriend.getDetail() %></p>
						 </div>
						 
						 <div class="comments">
							 <h3>Bạn thân khác của tôi</h3>
							 <%
							 	@SuppressWarnings("unchecked")
								ArrayList<Friend> listRelatedFriends = (ArrayList<Friend>) request.getAttribute("listRelatedFriends");
									if (listRelatedFriends != null && listRelatedFriends.size() > 0) {
											for (Friend item : listRelatedFriends) {
							 %>
							 <div class="comment-grid">
								 <a href="<%=request.getContextPath()%>/friend/detail?did=<%=item.getId()%>">
								 	<img src="<%=request.getContextPath() %>/BT3/images/<%=item.getPicture() %>" alt="<%=item.getPicture() %>">
								 </a>
								 <div class="comment-info">
								 <h4><a href="<%=request.getContextPath()%>/friend/detail?did=<%=item.getId()%>"><%=item.getName() %></a></h4>
								 <p><%=item.getPreview() %></p>
								 </div>
								 <div class="clearfix"></div>
							 </div>
							 <%}}else {%>	
							 	<p>Không có bạn nào để hiển thị</p>
							<%}%>
						</div>
					  </div>
					 <%}else {%>	
					 	<p>Không có bạn nào để hiển thị</p>
					<%}%>
				 </div>			 			 
			 </div>
				 <%@include file="/BT3/inc/right-bar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<script>
	<%if(itemFriend != null){%>
		document.getElementById("<%=itemFriend.getFl().getId()%>").classList.add('active');
	<%}%>
    document.getElementById("index").classList.add('active');
</script>
<%@include file="/BT3/inc/footer.jsp" %>