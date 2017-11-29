<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="top.haha233.entity.Score" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@include file="AutoChick.jsp" %>
<html>
<head>
    <title>查询成绩</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        form {
            margin: 100px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        input[type=text] {
            border: 1px #4d90fe solid;
        }

        input[type=submit] {
            width: 30px;
            height: 20px;
            background: url(img/fangdajing.png) no-repeat center;
            background-size: 20px 20px;
            border: 0;
            outline: none;
            transition: all 400ms ease;
            cursor: pointer;
        }

        input[type=submit]:hover {
            /*background-color: #b3d3eb #cbe1dd;*/
            box-shadow: #b3d3eb 2px 2px 2px;
        }

        input[type=submit]:active {
            background-color: #cbe1dd;
        }

        table {
            width: 500px;
            margin: 0 auto;
        }

        tr {
            background-color: #4d90fe;
            box-shadow: #cbe1dd 2px 2px 2px;
            transition: all 300ms ease;
        }

        tr:hover {
            background-color: black;
            box-shadow: #cbe1dd 4px 4px 4px;
        }

        tr:hover .updateButton {
            background: url(img/ic_update_white_24dp_2x.png) no-repeat center;
            background-size: 20px 20px;
        }

        tr:hover .deleteButton {
            background: url(img/ic_delete_white_24dp_2x.png) no-repeat center;
            background-size: 20px 20px;
        }

        td {
            text-align: center;
            color: #ffffff;
        }

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

        .deleteButton {
            width: 20px;
            height: 24px;
            background: url(img/ic_delete_black_24dp_2x.png) no-repeat center;
            background-size: 20px 20px;
            border: none;
            cursor: pointer;
            transition: all 400ms ease;
        }

        .updateButton {
            width: 20px;
            height: 24px;
            background: url(img/ic_update_black_24dp_2x.png) no-repeat center;
            background-size: 20px 20px;
            border: none;
            cursor: pointer;
            transition: all 400ms ease;
        }
    </style>
</head>
<script>
    function deleteCheck(str, id) {
        var r = confirm("您确定要删除该成绩么??\n" + str);
        if (r === true) {
            location.href = 'delete?id=' + id;
        }
    }

    function updateCheck(id) {
        location.href = 'updataBefore?id=' + id;
    }

    function backMain() {
        location.href = 'Main.jsp';
    }
</script>
<body>
<div>
    <form action="query" method="post">
        <input type="text" name="queryStr"
               placeholder="姓名/学号/科目">
        &nbsp;&nbsp;&nbsp;
        <input type="submit" value="">
    </form>
    <c:choose>
        <c:when test="${empty requestScope.scoresDate}">
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${requestScope.scoresDate.retMapSize<=0}">
                    <script>
                        alert('未查询到成绩！！！')
                    </script>
                </c:when>
                <c:otherwise>
                    <table>
                        <tr>
                            <td>姓名</td>
                            <td>课程</td>
                            <td>成绩</td>
                            <td>操作</td>
                        </tr>
                        <c:forEach
                                items="${requestScope.scoresDate.retMap}"
                                var="score"
                                varStatus="status">
                            <tr>
                                <td>${score.value.student.name}</td>
                                <td>${score.value.course.name}</td>
                                <td>${score.value.score}</td>
                                <td>
                                    <button class="updateButton"
                                            onclick="updateCheck(${score.value.id})">
                                    </button>
                                    <button
                                            class="deleteButton"
                                            onclick="deleteCheck('${score.value}',${score.value.id})">
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</div>
<div id="back" onclick="backMain()"></div>
</body>
</html>
