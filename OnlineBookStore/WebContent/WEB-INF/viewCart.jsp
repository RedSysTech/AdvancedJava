<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Shopping Cart</title>
 <link rel="stylesheet" href="css/styles.css">
    
    <style>
        /* Add custom CSS for table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
    </style>
</head>
<body>
	<h1>Your Shopping Cart</h1>
	
	<c:if test="${empty cart}">
		<p>Your cart is empty.</p>
		<c:forEach var="book" items="${availableBooks}">
			<form action="addToCart" method="post">
			
			<table>
            		<tr>
            		 	<th>Select</th> <!-- Add new column for selecting books -->
            		 	<th>Book Id</th>
                		<th>Title</th>
                		<th>Price</th>
                		
            		</tr>
            		<tr>
                		<td>
                            <input type="checkbox" name="selectedBooks" value="${book.id},${book.title},${book.price}">
                        </td>
                        <td>${book.id}</td>
                		<td>${book.title}</td>
                    	<td>${book.price}</td>
                    </tr>
            </table>
			
		</c:forEach>
		
		 <input type="submit" value="Add Selected Books to Cart"> <!-- Submit button to add selected books -->
		</form>
	</c:if>
	
	<c:if test="${not empty cart}">
		 <table>
		 	<tr>
                <th>Title</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            
            <c:forEach var="cartItem" items="${cart}">
            	<tr>
                    <td>${cartItem.book.title}</td>
                    <td>${cartItem.book.price}</td>
                    <td>${cartItem.quantity}</td>
                    <td><a href="removeFromCart?bookId=${cartItem.book.id}">Remove</a></td>
                </tr>
            </c:forEach>
            
            
		 </table>
			<p>Total items: ${cart.size()}</p>
	</c:if>
	
	<p><a href="index.jsp">Back to Home</a></p>
    <p><a href="logout">Logout</a></p>

</body>
</html>