
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="en">
<head>
<meta charset = "utf-8">
<link rel="stylesheet" href="/css/style.css">
<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/start/jquery-ui.min.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="/javascript/tableauthor.js"></script> 
<script src="/javascript/ajax.js"></script>
	</head>
		<body>
			<form id="deleteFormAuthor" action="/login/deleteauthor" method="post">
			<input id="deleteAuthorId" name="id" type="hidden" value="">
			</form>
			<h2 align="center">Authors</h2>
			
					<div>
						<p>INFO:</p>
						<p>Amount of authors: ${countOfAuthor}</p>
						<p>The youngest author: ${oldestAuthor.name}</p>
						<p>The oldest author: ${youngestAuthor.name}</p>
						<p>The best-selling author: ${bestAuthor.name}</p>
						<p>The least-selling author: ${leastAuthor.name}</p>
						<p>The most efficient author: ${efficientAuthor.name}</p>
					</div>
			
					<div id="dialog">
					    <p>Name: <span id="modalname"></span></p>
					    <p>Address: <span id="modaladdress"></span></p>
					    <p>Description: <span id="modaldescription"></span></p>
					</div>
					
				<button><a href="/login/formauthor">Add new author</a></button>
				<button><a href="/login/book">Return to table of books</a></button>
			
				<table>
	 		 	 	<tr>
						<th>Name</th>
						<th>Birth Day</th>
						<th>Address</th>
						<th>Description</th>
						<th>Author's book(s)</th>
						<th>Actions</th>
						</tr>
	 		 	 		  <c:forEach items="${author}" var="item">
	    					<tr>
	     			 		<td><c:out value="${item.name}" /></td>
	     			 		<fmt:formatDate pattern='dd/MM/yyyy' type='date' value='${item.birthday}' var="fDate"/>
	     			 		<td><c:out value="${fDate}" /></td>
	     			 		<td><c:out value="${item.address}" /></td>
	     			 		<td><c:out value="${item.description}" /></td>
	     			 		<td>Some books</td>
	     			 		<td>
				     		<button onclick="editAuthor(${item.id})">Edit it</button> 
							<button onclick="deleteAuthor(${item.id})">Delete it</button> 
							<button onclick="descriptionAuthor(${item.id})">Description</button>
	    					</td>
    					</tr>
 				</c:forEach>
 			</table>
	</body>
</html>