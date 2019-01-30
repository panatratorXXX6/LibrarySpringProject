
function editBook(id) {
	document.location="http://localhost:8080/login/book/"+ id;
}
 
				
function deleteBook(id) {
	  var txt;
	  var r = confirm("Do you really want delete this book?");
	  if (r) {
		document.getElementById("deleteBookId").value = id;
	    document.getElementById("deleteForm").submit(); 
	  } else {
	    txt = "Good choice";
	  }
	  document.getElementById("demo").innerHTML = txt;
} 

function descriptionBook(id) {
	confirm('AAA');
}	
			