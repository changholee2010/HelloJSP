<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
      padding: 50px;
      background-color: #f8f8f8;
      color: #333;
    }

    .container {
      background-color: #fff;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 30px;
      max-width: 600px;
      margin: 0 auto;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h1 {
      color: #d9534f;
    }

    p {
      margin-bottom: 20px;
      line-height: 1.6;
    }

    a {
      color: #007bff;
      text-decoration: none;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    pre {
      text-align: left;
      background-color: #eee;
      padding: 15px;
      border-radius: 5px;
      overflow-x: auto;
      font-size: 0.9em;
    }
  </style>
</head>

<body>
  <div class="container">
    <h1>죄송합니다! 오류가 발생했습니다.</h1>
    <p>요청하신 페이지를 처리하는 도중 문제가 발생했습니다.</p>

    <%-- isErrorPage="true" 설정으로 'exception' 객체에 접근 가능.
             JSTL은 EL (Expression Language)을 통해 이 객체에 접근합니다. --%>
    <c:set var="ex" value="${pageContext.exception}" />

    <%-- web.xml에서 설정하여 넘어오는 경우의 예외 객체 처리 (forward된 속성) --%>
    <c:if test="${empty ex}">
      <c:set var="ex" value="${requestScope['javax.servlet.error.exception']}" />
    </c:if>

    <c:if test="${not empty ex}">
      <p><strong>오류 메시지:</strong>
        <c:out value="${ex.message}" />
      </p>
      <p><strong>오류 종류:</strong>
        <c:out value="${ex.class.name}" />
      </p>

      <%-- 개발 및 디버깅 시에만 스택 트레이스를 표시하는 것이 좋습니다.
                 운영 환경에서는 보안상 노출하지 않는 것이 일반적입니다. --%>
      <p><strong>자세한 정보 (개발자용):</strong></p>
      <pre><c:out value="${ex}" /></pre> <%-- exception 객체를 직접 출력하면 스택 트레이스가 포함됩니다 --%>
    </c:if>

    <c:if test="${empty ex}">
      <p>자세한 오류 정보를 얻을 수 없습니다. (예외 객체가 비어있음)</p>
    </c:if>

    <p>문제가 계속 발생하면 관리자에게 문의해주세요.</p>
    <p><a href="<c:url value='/' />">홈페이지로 돌아가기</a></p>
  </div>
</body>

</html>