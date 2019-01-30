
function editAuthor(id) {
	document.location="/login/author/" + id;
}		

function deleteAuthor(id) {
	  var txt;
	  var r = confirm("Do you really want delete this Author?");
	  if (r) {
		document.getElementById("deleteAuthorId").value = id;
	    document.getElementById("deleteFormAuthor").submit(); 
	  } else {
	    txt = "Good choice";
	  }
	  document.getElementById("demo").innerHTML = txt;
}

