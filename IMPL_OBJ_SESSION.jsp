<html>

<head>
	<title> Welcome to RedSysTech!  </title>
</head>


<body>
		
		<br>
		
		<%
			
			session.setAttribute("user","john");
			String user = (String)session.getAttribute("user");
			out.println("Hello: "+user);

		   %> 

</body>

</html>

			