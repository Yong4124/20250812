<%@page import="dao.TinyDAO"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
int num = Integer.parseInt(request.getParameter("num"));

TinyDAO dao = new TinyDAO();
dao.delete(num);

// 삭제 후 목록으로 리다이렉트
response.sendRedirect("list.jsp");
%>
