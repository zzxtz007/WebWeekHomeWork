<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/24
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    String userinfo = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        if ("userinfo".equals(c.getName())) {
            userinfo = java.net.URLDecoder.decode(c.getValue(), "UTF-8");//解码
            break;
        }
    }
    if (!"".equals(userinfo) || session.getAttribute("userinfo") != null) {
        if ("".equals(userinfo)) {
            userinfo = (String) session.getAttribute("userinfo");
        }
//        out.print("<script >alert('欢迎登录，"+userinfo+"');</script>");
    } else {
        out.print("<script >alert('您还没有登录');location.href='login.html';</script>");
    }
%>