<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/22
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>show ……………………</h1>
<table border="1" style="margin: auto;text-align: center;"  cellpadding="0" width="800" >
    <thead>
        <th>姓名</th>
        <th>年龄</th>
        <th>出生年月</th>
    </thead>

    <tbody>
        <c:forEach items="${list}" var="stu">
            <tr>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
                <%--没有进行时间格式化处理--%>
                <%--<td>${stu.birthday}</td>--%>
                <%--对时间进行转化格式--%>
                <td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
