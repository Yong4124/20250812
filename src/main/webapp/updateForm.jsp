<%@page import="dto.TinyDTO"%>
<%@page import="dao.TinyDAO"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
int num = Integer.parseInt(request.getParameter("num"));
TinyDAO dao = new TinyDAO();
TinyDTO dto = dao.selectOne(num);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
<h2>글 수정</h2>
<form action="update.jsp" method="post">
    <input type="hidden" name="num" value="<%=dto.getNum()%>">
    <textarea name="content" rows="5" cols="40"><%=dto.getContent()%></textarea><br><br>
    <input type="submit" value="수정 완료">
</form>
</body>
</html>
