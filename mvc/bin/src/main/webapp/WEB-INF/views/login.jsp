<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hooray</title>
</head>
<body>
My first JSP - you access me from http://localhost:8080
<p>Try a request param e.g. http://localhost:8080?name=larry</p>
<p>I found the name of: </p><h1>${nameattr}</h1>
<%Date today = new Date();%>
<div>
Today's date is <%=today %>
</div>
<!-- This will do a GET and send the username as an http param
http://localhost:8080/login.do?username=gillian -->
<form action="login.do"><b>Please enter your name</b><input type="text" name="username"/>
<input type="submit" value="Login"/>
</form>

<form action="login.do" method="post">
<p>gillian / gillian is valid, everything else is invalid</p>
<b>Please post your name</b><input type="text" name="username"/>
<b>Please post your password</b><input type="password" name="password"/>
<input type="submit" value="Login"/>
</form>
</body>
</html>