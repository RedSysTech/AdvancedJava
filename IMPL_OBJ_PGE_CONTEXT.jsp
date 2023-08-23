<html>

<head>
	<title> Welcome to RedSysTech!  </title>
</head>


<body>
		
		<br>

	
	
		<%
        // Page Context: Items added in this request's scope
        String newItem = request.getParameter("item");
        if (newItem != null && !newItem.isEmpty()) {
            out.println("<p>Added: " + newItem + "</p>");
        }
    %>
   
	


</body>

</html>

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewCart.jsp");
        dispatcher.forward(request, response);