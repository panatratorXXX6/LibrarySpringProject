
function descriptionAuthor(id) {
	
	$.ajax({
		url:'/login/ajaxauthor/' + id,
        type: 'POST',
        data: {id: id},
        dataType: 'json',
        contentType: 'application/json',
        cache: false,
        success: function(author) {
        	$("#modalname").html(author.name);
			$("#modaladdress").html(author.address);
			$("#modaldescription").html(author.description);
			$("#dialog").dialog("open");
        },
        error: function(xhr) {
            respError = xhr;
        }
    });
};
   
$(document).ready(function() {
	$("#dialog").dialog({
		autoOpen: false		
	});
});
