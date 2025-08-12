<%@page import="dto.TinyDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.TinyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
TinyDAO dao = new TinyDAO();
List<TinyDTO> list = dao.selectList();
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
table, th, td{
border: 1px solid #ccc;
vorder-collapse: collapse;
}
th, td {padding: 10px 20px;}
</style>
</head>
<body>
<table>
<%
for (TinyDTO dto : list) {
	
%>
	<tr>
    <td><%=dto.getNum() %></td>
    <td><%=dto.getContent() %></td>
    <td>
        <form action="updateForm.jsp" method="get" style="display:inline;">
            <input type="hidden" name="num" value="<%=dto.getNum()%>">
            <input type="submit" value="수정">
        </form>
        <form action="delete.jsp" method="post" style="display:inline;">
            <input type="hidden" name="num" value="<%=dto.getNum()%>">
            <input type="submit" value="삭제">
        </form>
    </td>
</tr>

<% 
}
%>
</table>
<button type="button" onclick="location.href='insertForm.jsp' ">글쓰기</button>
<button type="button" value="삭제" onclick="location.href='delete.jsp'">삭제</button>
</body>
</html>