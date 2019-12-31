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
<p>I found the name of: ${nameattr}</p>
<%Date today = new Date();%>
<div>
Today's date is <%=today %>
</div>
</body>
</html>