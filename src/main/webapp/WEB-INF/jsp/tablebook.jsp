<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
<link rel="stylesheet" href="/css/style.css">
<script src="/javascript/tablebook.js"></script>
</head>
	<body>
			<form id="deleteForm" action="/login/deletebook" method="post" >
			<input id="deleteBookId" name="id" type="hidden" value="">
			</form>
			
			<h2 align="center">Books</h2>
			<button><a href="/login/formbook">Add new book</a></button>		
			<button><a href="/login/author">Return to table of authors</a></button>
				<table>
					<tr>
						<th>ISBN</th>
						<th>Name</th>
						<th>Age</th>
						<th>Publish date</th>
						<th>Count</th>
						<th>Book's author(s)</th>
						<th>Actions</th>
					</tr>
	 		 	 		<c:forEach items="${book}" var="item">
	    					<tr>
	     			 		<td><c:out value="${item.isbn}" /></td>
	     			 		<td><c:out value="${item.name}" /></td>
	     			 		<td><c:out value="${item.age}" /></td>
	     			 		<fmt:formatDate pattern='dd/MM/yyyy' type='date' value='${item.publishdate}' var="pDate"/>
	     			 		<td><c:out value="${pDate}" /></td>
	     			 		<td><c:out value="${item.count}" /></td>
	     			 		<td>Some authors</td>
	     			 		<td>
	     			 		<button onclick="editBook(${item.id})" >Edit it</button>
							<button onclick="deleteBook(${item.id})">Delete it</button>
	    					</td>
    					</tr>
 				</c:forEach>
			</table>
	</body>
</html>