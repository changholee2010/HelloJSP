<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp" />
<h3>register_form.jsp</h3>

<form action='addBoard.do' method='post'>
  <table class='table'>
    <tr>
      <th>제목</th>
      <td><input type="text" required name="title" class='form-control'></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td><input type="text" required name="writer" class='form-control'></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea required name="content" class='form-control'></textarea></td>
    </tr>
    <tr>
      <td colspan='2' align='center'>
        <input type="submit" class='btn btn-primary'>
      </td>
    </tr>
  </table>
  </form>

<jsp:include page="includes/footer.jsp" />