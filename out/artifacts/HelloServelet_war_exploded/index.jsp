<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/10/13
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>登录页面</title>
</head>
<body>
<style>
  #login{
    align-content: center;
  }
</style>
<div id="login" align="center">
<form  action="register" method="post">
  账号: <input type="text" name="name"> <br>
  密码: <input type="password" name="password"> <br>
  <input type="submit" value="注册">
</form>
<table width="200" border="1">
</div>
<%@include file="copyright"%>

</body>
</html>
