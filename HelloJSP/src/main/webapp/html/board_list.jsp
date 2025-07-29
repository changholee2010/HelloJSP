<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page import="com.yedam.service.BoardServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
  <table border='2'>
    <tbody>
  <%
  BoardService svc = new BoardServiceImpl();
  List<BoardVO> list = svc.boardList();
  for (BoardVO board : list) {
  %>
      <tr>
        <td><%=board.getBoardNo() %></td>
        <td><%=board.getTitle() %></td>
        <td><%=board.getWriter() %></td>
      </tr>
  <%	  
  }
  %>
    </tbody>
  </table>
</body>
</html>