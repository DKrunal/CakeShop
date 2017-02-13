<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HTTP Status 403- Access is denied ${errorMessage}</h1>
<c:choose>
<c:when test="${empty username}">
<h2>you do not have permission to access this page</h2>
</c:when>
<c:otherwise>
<h2>Username :${username} you do not have permission to access this page</h2>
</c:otherwise>
</c:choose>
</body>
</html>