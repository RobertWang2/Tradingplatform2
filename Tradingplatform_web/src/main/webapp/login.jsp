<%@ page import="java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: Robert_Wang
  Date: 2018/8/17
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<script language=JavaScript>
    var timerID = null;
    var timerRunning = false;
    function showtime() {
        var now = new Date();
        document.clock.thetime.value = now.toString();
        timerID = setTimeout("showtime()", 1000);
        timerRunning = true;
    }
</script>
<body onload="showtime()">
<form name=clock >
    <input name=thetime style="font-size: 9pt;color:#000000;border:0" size=100>
</form>
<%
    String username = "";
    String password = "";
    Cookie[] cookie = request.getCookies();
    if(cookie!=null && cookie.length>0){
        for (Cookie c: cookie) {
            if(c.getName().equals("username")){
                username = c.getValue();
            }
            if(c.getName().equals("password")){
                password = c.getValue();
            }
        }
    }

%>
<div id="container">
    <div class="logo">
        <a href=""><img src= "/resources/images/logo.png" alt=""/></a>
    </div>
    <div id="box">
        <form action="/judge" method="post">
            <p class="main">
              <table>
            <tr>
                <td><label>用户名：</label></td>
                <td><input name="username"  value="<%=username%>" placeholder="username"/></td>
            </tr>
            <tr>
                <td><label>密码： </label></td>
                <td><input type="password" name="password" value="<%=password%>" placeholder="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="checkbox" name="userCookie" checked="checked"/>十天内免登陆</td>
            </tr>
            <tr>
                <td colspan="2" align="left"><input type="reset" value="重置"/> <input type="submit" value="登录" /></td>
            </tr>
              </table>

            </p>
        </form>
    </div>
</div>



</body>

</html>
