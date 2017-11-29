<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="top.haha233.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/24
  To change this template use File | Settings | File Templates.
Time: 15:35
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@include file="AutoChick.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
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
<body>
<form action="Add" method="post">
    学生学号:<input type="text" name="stuid"><br><br>
    学生课程:<select name="course">
    <c:forEach items="${requestScope.allCourses}"
               var="course" varStatus="status">
        <option value="${course.id}">${course.name}
        </option>
    </c:forEach>
</select><br><br>
    成绩:<input type="text" name="score"><br>
    <input type="submit" value="提交">
</form>
<div id="back" onclick="backMain()"></div>
</body>
</html>
