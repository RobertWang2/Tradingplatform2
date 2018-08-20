<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/17
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h1>登录成功</h1>
    <h1 align="center">欢迎<font color="red"><%=request.getParameter("username")%></font>进入系统</h1><hr>
    <%
//        获取用户名和密码，创建Cookie，设置之后再增加响应。
            String[] userCookie = request.getParameterValues("userCookie");
            if(userCookie!=null && userCookie.length>0){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Cookie usernameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password",password);
            usernameCookie.setMaxAge(86400);
            passwordCookie.setMaxAge(86400);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        else {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null && cookies.length>0){
                for(Cookie c : cookies){
                    if(c.getName().equals("username") || c.getName().equals("password")){
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
        }

    %>
    <form name="form1" action="list" method="post">
        <input type="hidden" name="username" value=<%=request.getParameter("username")%>>
        <a href='javascript:document.form1.submit();'>用户详情信息</a>

    </form>

    <%--<a href="/list?username=<%=request.getParameter("username")%>" methods="post">用户详情信息</a>--%>
</body>
</html>
