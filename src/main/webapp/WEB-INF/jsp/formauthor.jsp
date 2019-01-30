<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<html>
<head>
</head>
	<body>
		<div align="center">
			<h3>Create author</h3>
	      		  <form action="/login/addauthor" method="POST">
			  			Author name: <input type="text" name="name"><br>
			  			Birth Day: <input type="text" name="birthday"><br>
			  			Address: <input type="text" name="address"><br>
			  			Description: <input type="text" name="description"><br>
			 			<input type="submit" value="Submit">
	 					<p>Click the "Submit" button once you're done</p>
				</form> 
			</div>	
		</body>
</html>