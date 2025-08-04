<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>WEB-INF/html/js.jsp</title>
</head>

<body>
  <h3>JS연습</h3>
  <div style="display: none;">
    ID: <input type="text" id="mid"><br>
    Name: <input type="text" id="mname"><br>
    Point: <input type="number" id="point"><br>
    <button id="addBtn">추가</button>
  </div>
  <div style="display: none;">
    <ul id="list">
      <li>이름:홍길동,포인트:90</li>
    </ul>
  </div>
  
  <div>
    이름: <input type="text" id="std_name"><br>
    영어: <input type="number" id="std_score"><br>
    <button id="addList">추가</button>
  </div>
  <div>
    <table border="2">
      <thead>
        <tr>
          <th>이름</th><th>점수</th>
        </tr>
      </thead>
      <tbody id="tlist">
        <tr><td>홍길동</td><td>90</td></tr>
      </tbody>
    </table>
  </div>

  <script type="text/javascript" src='js/todo1.js'></script>
</body>

</html>