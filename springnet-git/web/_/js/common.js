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
	
	/* Xử lý nút Test1 Test2 */
	
	var dialog1 = null, dialog2 = null;
	var uiDialogOpts = {
			title: 'JQuery Ajax Dialog',
			modal: true,
			autoOpen: false,
			width: 720,
			height: 300,
			open: function() {
				$('#ui-dialog').load($ctx + '/user' + $ext);
			},
			buttons: {
				'OK': function() {
					$(this).dialog('destroy');
				}
			}
	};
	
	$('#test1').live('click', function() {
		if (!dialog1) {
			dialog1 = new goog.ui.Dialog();
		}
		dialog1.setTitle('I have an Iframe mask :)');
		dialog1.setContent('Some windowed elements leak through standard divs so ' +
			'we add an iframe to mask the nasties.');
		dialog1.setButtonSet(goog.ui.Dialog.ButtonSet.OK);
		dialog1.setVisible(true);
	});
	
	$('#test2').live('click', function() {
		if (!dialog2) {
			dialog2 = $('#ui-dialog');
		}
		dialog2.dialog(uiDialogOpts);
		dialog2.dialog('open');
		return false;
	});

});