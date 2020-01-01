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

<%Date today = new Date();%>
<div>
Today's date is <%=today %>
</div>
This will do a GET as we've not defined the method of this form.  
It will send the username as an http param
http://localhost:8080/login.do?username=gillian.  <br> You will be returned to this login page
<form action="login.do"><b>Please enter your name</b><input type="text" name="username"/>
<input type="submit" value="Please Login"/>
</form>

<p>I found the name of: </p><h1>${nameattr} - look at the url</h1>
<p>This will do a post as we've defined the method of this form as POST</p>
<form action="login.do" method="post">
<p>gillian / gillian is valid, everything else is invalid</p>
<b>Please post your name</b><input type="text" name="username"/>
<b>Please post your password</b><input type="password" name="password"/>
<input type="submit" value="Please Login"/>
</form>

<p>This will do a spring-mvc post as we've defined the method of this form as POST</p>
<form action="/spring-mvc/login" method="post">
<p>gillian / gillian is valid, everything else is invalid</p>
<b>Please post your name</b><input type="text" name="username"/>
<b>Please post your password</b><input type="password" name="password"/>
<input type="submit" value="Please Login"/>
</form>
</body>
</html>