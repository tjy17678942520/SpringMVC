<%@ page import="org.w3c.dom.css.CSSStyleRule" %><%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

String baseString = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=baseString%>">
    <title>首页</title>
</head>
<body>
<h2>五种数据提交方式</h2>
<hr>
<h3>单个数据提交</h3>
<form action="one.action" method="get">
    姓名：<input type="text" value="" name="name" placeholder="请输入用户名">
    年龄：<input type="text" name="age" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>

<hr>
<form action="two.action" method="get">
    姓名：<input type="text" value="" name="uname" placeholder="请输入用户名">
    年龄：<input type="text" name="uage" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>

<hr>
<a href="/three/张撒旦/67.action">动态占位符传参</a>

<hr>
<form action="four.action" method="get">
    姓名：<input type="text" value="" name="username" placeholder="请输入用户名">
    年龄：<input type="text" name="userage" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>

<hr>
<form action="/five.action" method="get">
    姓名：<input type="text" value="" name="name" placeholder="请输入用户名">
    年龄：<input type="text" name="age" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>





</body>
</html>
