<html>

<head>
	<title> Welcome to RedSysTech!  </title>
</head>


<body>
		<h1> Hello Karthik! </h1>
		<br>
		
		<%
			String name = request.getParameter("name");
			response.setContentType("text/html");
			response.getWriter().println("Hello: "+name);

		   %> 

</body>

</html>

			