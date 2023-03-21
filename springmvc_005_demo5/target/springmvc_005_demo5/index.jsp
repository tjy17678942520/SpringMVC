<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/20
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#senBtn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/list.do",
                    type:"POST",
                    dataType:"json",
                    data:{
                        na:"我是来测试的"
                    },
                    success:function (res) {
                        var s = '';
                        $.each(res,function (i,stu) {

                            s += stu.name +"---" + stu.age + "<br>";
                        });

                        //回显数据
                        $("#show-box").html("<hr>"+s);
                    }
                })
            })
        });
    </script>
</head>
<body>
<a id="senBtn">点击访问服务器返回数据</a>
<div id="show-box"></div>
</body>
</html>
