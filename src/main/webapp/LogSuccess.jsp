<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub =(UserBean)session.getAttribute("ub");
String filterName = (String)request.getAttribute("filterName");
out.println("Welcome User : "+ub.getfName()+"<br>");
out.println("LoginFilter : "+filterName+"<br>");
%>
<a href="logout">Logout</a>
</body>
</html>