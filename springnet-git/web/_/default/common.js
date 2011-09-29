function renderPage(url) {
	$.get(url, function(data) {
		$('#result').html(data);
	});
};


/* === Document Ready for assigning events === */

$(function() {
	
	var ids = '{"ids":["id", "passwd"]}';
	var json = $.parseJSON(ids);
	
	$.each(json.ids, function(idx, el) {
	});
	
	/* Xử lý login */
	
	$('#signin').live('click', function(evt) {
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
			invalidHandler: function(form, validator) {
				$('#signin-box').stop(true, true);
				$('#signin-box').effect('shake', { times:2, distance:5 }, 50);
			},
			submitHandler: function(form) {
				form.submit();
			}
		});
		frm.submit();
	});
	
	/* Xử lý nút Test1 Test2 */
	
	var dialog1 = null;
	
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
		var url = $ctx + '/user' + $ext;
		var dlgConfirm = jTien.callJqDialog('dlg-confirm',
				'Are you sure you want to delete selected topic?', {
			title: 'Delete Topic Confirmation',
			buttons: {
				'OK': function() {
					jTien.callJqDialog('dlg-confirm', url, {
						buttons: {
							'Close': function() {
								$(this).dialog('destroy');
							}
						}
					});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		});
		dlgConfirm.dialog('open');
		return false;
	});

});