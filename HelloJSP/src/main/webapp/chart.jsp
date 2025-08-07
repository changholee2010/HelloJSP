<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">

    google.charts.load('current', {'packages': ['corechart']});

    let countPerUser = [
      ['User', 'Count']
    ]

    // 비동기처리.
    fetch('chartData.do')
      .then(resolve => resolve.json())
      .then(result => {
        // console.log(result); // 서버데이터.
        // for .. in 활용해서 
        for (let prop in result) {
          countPerUser.push([prop, result[prop]]);
        }
        console.log(countPerUser); // 출력.
        google.charts.setOnLoadCallback(drawChart);
      })
      .catch(err => console.log(err));

    function drawChart() {
      var data = google.visualization.arrayToDataTable(countPerUser);
      var options = {
        title: '회원별 게시글 작성현황'
      };
      var chart = new google.visualization.PieChart(document.getElementById('piechart'));
      chart.draw(data, options);
    }
  </script>
</head>

<body>
  <div id="piechart" style="width: 900px; height: 500px;"></div>
</body>

</html>