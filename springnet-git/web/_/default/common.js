function renderPage(url) {
	$.get(url, function(data) {
		$('#result').html(data);
	});
};


/* === Document Ready for assigning events === */

$(function() {
	
	/* Reset button */

	$('#signin-form').delegate('#reset', 'click', function(evt) {
		jTien.resetForm('signin-form');
	});

	/* Xử lý login */
	
	$('#signin-form').delegate('#signin', 'click', function(evt) {
		if ($debug && !isIEBrowser()) {
			console.log('#' + this.id + ' button is clicked.');
		}
		
		var loginForm = $(this).parents('form');
		
		loginForm.validate({
			rules: {
				id: { required: true, minlength: 2 },
				passwd: { required: true, minlength: 3 }
			},
			messages: {
				id: { required: 'Enter your ID (username, email).', minlength: $.format('ID, at least {0} characters.') },
				passwd: { required: 'Enter your Password.', minlength: $.format('Password, at least {0} characters.') }
			},
			invalidHandler: function(form, validator) {
				$('#signin-box').stop(true, true).effect('shake', { times:2, distance:5 }, 50);
			},
			submitHandler: function(frm) {
				jTien.ajaxSubmit(frm);
			}
		});
		
		loginForm.submit();
	});
	
	/* Xử lý nút Test1 Test2 */
	
	var googDialog = null;
	
	$('#test1').live('click', function() {
		if (!googDialog) {
			googDialog = new goog.ui.Dialog();
		}
		googDialog.setTitle('I have an Iframe mask :)');
		googDialog.setContent('Some windowed elements leak through standard divs so ' +
			'we add an iframe to mask the nasties.');
		googDialog.setButtonSet(goog.ui.Dialog.ButtonSet.OK);
		googDialog.setVisible(true);
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