function renderPage(url) {
	$.get(url, function(data) {
		$('#result').html(data);
	});
};

$(function() {
	
var ids = '{"ids":["id", "passwd"]}';
var json = $.parseJSON(ids);

$.validator.setDefaults({
	debug:$debug,
	errorClass:'error', validClass:'valid',
	onkeyup:false, onfocusout:false
});

$.each(json.ids, function(idx, el) {
});

/* Xử lý login */

$('#signin').live('click', function() {
	if ($debug && !isIEBrowser()) {
		console.log('#' + this.id + ' button is clicked.');
	}
	var frm = $('#signin-form');
	frm.validate({
		rules: {
			id: { required: true, minlength: 2 },
			passwd: { required: true, minlength: 3 }
		},
		messages: {
			id: { required: 'Enter your ID (username, email).', minlength: $.format('ID, at least {0} characters.') },
			passwd: { required: 'Enter your Password.', minlength: $.format('Password, at least {0} characters.') }
		},
		highlight : function(el, errorClass, validClass) {
			$(el).addClass(errorClass).removeClass(validClass);
			$(el.form).find('span[class~=' + el.id + ']').addClass(errorClass);
			$('#signin-box').stop(true, true).effect('shake', { times:2, distance:5 }, 50);
		},
		unhighlight: function(el, errorClass, validClass) {
			$(el).addClass(validClass).removeClass(errorClass);
			$(el.form).find('span[class~=' + el.id + ']').removeClass(errorClass);
		},
		invalidHandler: function(form, validator) {
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
	frm.submit();
});

});