$(function() {
	$('#btn').bind('click', function() {
		alert('Submited to ' + $('form').attr('action'));
		$('form').submit();
	});
});