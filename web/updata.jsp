<%@ page import="top.haha233.entity.Score" %>
<%@ page import="top.haha233.DAO.ScoreDAO" %>
<%@ page import="top.haha233.util.MySqlJdbc" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/25
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@include file="AutoChick.jsp" %>
<html>
<head>
    <title>更新</title>
    <style>
        #back {
            width: 40px;
            height: 40px;
            position: fixed;
            right: 40px;
            top: 40px;
            background: url(img/ic_arrow_back_white_24dp_2x.png) no-repeat center;
            background-size: 40px 40px;
            cursor: pointer;
            transition: all 400ms ease;
        }

        #back:hover {
            box-shadow: #b3d3eb 5px 5px 5px;
            background: url(img/ic_arrow_back_black_24dp_2x.png) no-repeat center;

            background-size: 40px 40px;
        }
    </style>
    <script>
        function backMain() {
            location.href = 'Main.jsp';
        }
    </script>
</head>
<body>
<form action="updata?id=${requestScope.score.id}" + method="post">
    姓名:
    <span>${requestScope.score.student.name}</span><br><br>
    课程:
    <span>${requestScope.score.course.name}</span><br><br>
    成绩: <input type="text" name="score" value="${requestScope.score.score}"><br><br>
    <input type="submit" value="提交">
</form>
<div id="back" onclick="backMain()"></div>
</body>
</html>
