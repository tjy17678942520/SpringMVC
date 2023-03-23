<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/22
  Time: 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/one.do">1、请求转发界面</a>

<hr>
<a href="${pageContext.request.contextPath}/two.do">2、请求转发action</a>
<hr>
<a href="${pageContext.request.contextPath}/three.do">3、重定向界面</a>
<hr>
<a href="${pageContext.request.contextPath}/four.do">4、重定向action</a>
<hr>
<a href="${pageContext.request.contextPath}/five.do">5、这是随便跳转……</a>

<hr>
<form action="/date.do" method="POST">
    时间: <input type="date" name="data">
    <button type="submit">提交</button>
</form>

<hr>
<a href="${pageContext.request.contextPath}/student.do">查询学生信息</a>
</body>
</html>
