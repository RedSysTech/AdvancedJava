<html>

<head>
	<title> Welcome to RedSysTech!  </title>
</head>


<body>
		
		<br>

	<%
		try{
			int z = 1/0;
		}
		catch(Exception ex){
			out.println("Error occurred here!" + ex.getMessage());
		}
	%>


</body>

</html>

			