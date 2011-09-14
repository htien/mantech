$().ready(function() {
	 $('#showComplaintEdit').bind('click', function() {
		 $.post('/springnet/tien/complaintEdit.htm', function(data) {
			$.facebox(data); 
		 });
	 });
});