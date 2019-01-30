<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<html>
<head>
</head>
   <body>
   		<div align="center">
   			<h3>Create book!</h3>
      			 <form action="/login/addbook" method="POST">
		  			ISBN number: <input type="text" name="isbn" ><br>
		  			Name of book:<input type="text" name="name"><br>
		  			Book age: 	 <input type="text" name="age"><br>
		  			Publish Date:<input type="text" name="publishdate"><br>
		  			Count: 		 <input type="text" name="count"><br>
					<input type="submit" value="Submit">
					<p >Click the "Submit" button once you're done</p>
				</form> 
			</div>	
   		</body>
</html>