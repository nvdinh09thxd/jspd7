<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/BT3/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			 <%
			 	String msg = request.getParameter("msg");
			 	String name = request.getParameter("name");
			    String email = request.getParameter("email");
			    String phone = request.getParameter("phone");
			    String message = request.getParameter("message");
				if("1".equals(msg)){
				    	out.print("<div style=\"background: yellow; color: green; font-weight: bold; padding: 4px\">Gửi liên hệ thành công!</div>");
				}
				if("0".equals(msg)){
				    out.print("<div style=\"background: yellow; color: red; font-weight: bold; padding: 4px\">Gửi liên hệ thất bại!</div>");
			    }
			 %>
			 
			  <form action="<%=request.getContextPath()%>/friend/contact" method="post">
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" value="<%if(name!=null) out.print(name); %>" required="" name="name">
						<input type="text" placeholder="E-mail" value="<%if(email!=null) out.print(email); %>" required="" name="email">
						<input type="text" placeholder="Phone" value="<%if(phone!=null) out.print(phone); %>" required="" name="phone">
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message" name="message"><%if(message!=null) out.print(message); %></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>
<script>
    document.getElementById("contact").classList.add('active');
</script>
<%@include file="/BT3/inc/footer.jsp" %>