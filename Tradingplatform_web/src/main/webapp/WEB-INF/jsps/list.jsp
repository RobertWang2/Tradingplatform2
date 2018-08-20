<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/17
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h1 align="center">欢迎<font color="red">${user.username}</font>进入系统</h1><hr>
<h2>用户信息</h2><br>
姓名：${user.username}<br>
年龄：${user.age}<br>
余额：${user.balance}<br>
出生年月：${user.birthday}<br>
信用度：${user.credit}%<br>
邮箱：${user.email}<br>
个人介绍：${user.remark}<br>
</body>
</html>
