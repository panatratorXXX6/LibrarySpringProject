<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<html>
<head>
</head>
	 <body>
	   	<h3>Create book!</h3>
   			<div align="center">
     			<form action="/login/editbook" method="POST">
     						 <input type="hidden" name="id" value="${book.id}">
	  			ISBN number: <input type="text" name="isbn" value="${book.isbn}"><br>
	  			Name of book:<input type="text" name="name" value="${book.name}"><br>
	  			Book age: 	 <input type="text" name="age" value="${book.age}"><br>
	  			Publish Date:<input type="text" name="publishdate" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${book.publishdate}" />' ><br>
	  			Count: 		 <input type="text" name="count" value="${book.count}"><br>
	  			<p><input type="submit" value="Submit"></p>
	  			<p>Click the "Submit" button once you're done</p>
				</form>
			</div>	
	   </body>
</html>
