<%@page import="dto.TinyDTO"%>
<%@page import="dao.TinyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String content = request.getParameter("content");
TinyDAO dao = new TinyDAO();
dao.insertOne(new TinyDTO(0, content));
response.sendRedirect("list.jsp");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>