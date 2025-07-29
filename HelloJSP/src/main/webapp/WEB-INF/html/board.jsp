<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />
<%
  BoardVO board = (BoardVO) request.getAttribute("board_info");
%>

<h3>글상세화면</h3>
<table class="table">
  <tr>
    <th>글번호</th>
    <td><%=board.getBoardNo()%></td>
    <th>조회수</th>
    <td><%=board.getViewCnt()%></td>
  </tr>
  <tr>
    <th>제목</th>
    <td colspan='3'><%=board.getTitle()%></td>
  </tr>
  <tr>
    <th>내용</th>
    <td colspan='3'><%=board.getContent()%></td>
  </tr>
  <tr>
    <th>작성자</th>
    <td><%=board.getWriter()%></td>
    <th>작성일시</th>
    <td><%=board.getCreationDate()%></td>
  </tr>
</table>

<jsp:include page="includes/footer.jsp" />