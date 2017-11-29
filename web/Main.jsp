<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/24
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@include file="AutoChick.jsp" %>
<html>
<head>
    <title>学生成绩管理</title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0;
            box-sizing: border-box;
        }

        #Main {
            margin: 100px auto auto auto;
            width: 500px;
            height: 400px;
        }

        body > div > div {
            width: 500px;
        }

        .bigbutton {
            float: left;
            width: 200px;
            height: 100px;
            background-color: dodgerblue;
            transition: all 400ms ease;
            color: white;
            font-size: 35px;
            text-align: center;
            line-height: 100px;
            cursor: pointer;
            z-index: 1;
        }

        .bigbutton:hover {
            box-shadow: black -3px -3px 5px;
            background-color: deeppink;

        }
    </style>
</head>
<body>
<div id="Main">
    <div>
        <div class="bigbutton" onclick="addIn()">录入成绩</div>
        <div class="bigbutton" onclick="query()">查询成绩</div>
    </div>
    <div>
        <div class="bigbutton" onclick="score()">成绩维护</div>
        <div class="bigbutton">暂未开放</div>
    </div>
</div>
<script>
    function addIn() {
        location.href = 'addScoreBefore'
    }

    function query() {
        location.href = 'queryScore.jsp'
    }

    function score() {
        location.href = 'query?queryStr='
    }
</script>
</body>
</html>
