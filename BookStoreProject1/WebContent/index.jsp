<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome to RedSysTech - Book Data from DB using JDBC</title>
	</head>
	<body>
		<h1>Welcome to JDBC Data from the Database</h1>
	
		
		<c:forEach   var="mybook"  items = "${abc}">
			<table>
			
					<tr>
            		 	
            		 	<th>Book ID</th>
                		<th>Title</th>
                		<th>Book Author</th>
                		
            		</tr>
            		
            		<tr>
            			<td><c:out value="${mybook.id}"/></td>
            			<td><c:out value="${mybook.title}"/></td>  
        				<td><c:out value="${mybook.author}"/></td>
            		</tr>
			
			
			</table>
		</c:forEach>
		
	</body>
</html>