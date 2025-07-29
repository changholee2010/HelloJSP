<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>Hello, JSP</h3>
  <%
  String msg = "Hello, World";
  System.out.println(msg);
  int age = 20;
  %>
  <p>여기는 HTML영역입니다</p>
  <%
  if (age >= 20) {
  %>
  <p>성년입니다</p>
  <%
  } else {
  %>
  <p>미성년입니다</p>
  <%
  }
  %>
</body>
</html>