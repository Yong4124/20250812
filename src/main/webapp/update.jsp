<%@page import="dao.TinyDAO"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
request.setCharacterEncoding("UTF-8");

int num = Integer.parseInt(request.getParameter("num"));
String content = request.getParameter("content");

TinyDAO dao = new TinyDAO();
dao.update(num, content);

// 수정 후 목록으로 리다이렉트
response.sendRedirect("list.jsp");
%>
