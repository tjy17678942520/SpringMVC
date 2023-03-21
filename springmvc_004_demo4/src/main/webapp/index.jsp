<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo2.active">点击跳转主页</a>

<hr>
<form action="/demo2.do" method="POST">
    姓名：<input type="text" value="" name="name" placeholder="请输入用户名">
    年龄：<input type="text" name="age" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>

</body>
</html>
