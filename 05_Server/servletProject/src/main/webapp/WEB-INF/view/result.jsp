<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 style="color:hotpink"><%= request.getParameter("inputNmae") %>님의 가입을 환영합니다.
	</h3>

	<ul>
		<li> id : <%= request.getParameter("inputId") %></li>	
		<li> pw : <%= request.getParameter("inputPw") %></li>	
	</ul>

	<% if(!request.getParameter("introduction").equals("")){ %>
	<h4>자기소개</h4>
	<p>
	<%= request.getParameter("introduction") %>
	<%} %>
	

</body>
</html>