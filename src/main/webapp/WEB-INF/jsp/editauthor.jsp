<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<html>
<head>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/javascript/jquery.js"></script>

</head>
	<body>
		<h3>Create author</h3>
			<div align="center">
				<form action="/login/editauthor" method="POST">
							<input type="hidden" name="id" value="${author.id}">
				Name: 		<input type="text" name="name" value="${author.name}"><br>
				Birth Day	<input type="text" name="birthday" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${author.birthday}" />'><br>
				Address 	<input type="text" name="address" value="${author.address} "><br>
				Description <input type="text" name="description" value="${author.description} "><br>
				List of books
				
							<select name="bookofauthors" multiple="multiple">
							<c:forEach var="item" items="${authorBooks}" >
							<option value="${item.id}" 
							<c:if test="${authorBooksId.contains(item.id)}">selected="selected"</c:if> >
							<c:out value="${item.name}"></c:out>
							</option>
							</c:forEach>
							</select>
							
				<p><input type="submit" value="Submit"></p>
				<p>Click the "Submit" button once you're done</p>
				</form>
			</div>
	 </body>
</html>