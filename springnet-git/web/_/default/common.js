/* === Document Ready for assigning events === */

$('#signin_pagelet').ready(function() {
	
	var signInBox = '#signin-box',
		signInForm = '#signin-form',
		signInButton = '#signin',
		resetButton = '#reset';
	
	/* Reset button */

	$(signInForm).delegate(resetButton, 'click', function(evt) {
		jTien.resetForm(signInForm);
	});
	
	/* Login button */
	
	$(signInForm).delegate(signInButton, 'click', function(evt) {
		if ($debug && !isIEBrowser()) {
			console.log('#' + this.id + ' button is clicked.');
		}
		
		$(signInForm).validate({
			rules: {
				id: { required: true, minlength: 2 },
				passwd: { required: true, minlength: 3 }
			},
			messages: {
				id: { required: 'Enter your username or email).', minlength: 'ID, at least {0} characters.' },
				passwd: { required: 'Enter your password.', minlength: 'Password, at least {0} characters.' }
			},
			invalidHandler: function(form, validator) {
				$(signInBox).stop(true, true).effect('shake', { times:2, distance:5 }, 50);
			},
			submitHandler: function(form) {
				jTien.ajaxSubmit(form)
					.success(function(data) {
						jTien.callJqDialog('ajax-response', data, {
							buttons: {
								'Close': function() {
									$(this).dialog('destroy');
								}
							}
						}).dialog('open');
					})
					.complete(function(data) {
						jTien.resetForm(signInForm);
					});
			}
		});
		
		$(signInForm).submit();
		return false;
	});
	
});

$('#signin_pagelet #testZone').ready(function() {
	
	/* Xử lý nút Test1 Test2 */
	
	var testZone = '#testZone',
		button1 = '#test1',
		button2 = '#test2',
		googDialog = null;

	$(testZone).delegate(button1, 'click', function() {
		if (!googDialog) {
			googDialog = new goog.ui.Dialog();
		}
		googDialog.setTitle('I have an Iframe mask :)');
		googDialog.setContent('Some windowed elements leak through standard divs so ' +
			'we add an iframe to mask the nasties.');
		googDialog.setButtonSet(goog.ui.Dialog.ButtonSet.OK);
		googDialog.setVisible(true);
	});
	
	$(testZone).delegate(button2, 'click', function() {
		var url = $ctx + '/user' + $ext,
			jsDialogs = $.parseJSON('\
					{\
						"dlgConfirm": {\
							"id": "dlg-confirm",\
							"title": "Display Users Confirmation",\
							"content": "Are you sure you want to show user list?"\
						}\
					}'),
			jsDlgConfirm = jsDialogs.dlgConfirm,
			dlgConfirm = jTien.callJqDialog(jsDlgConfirm.id, jsDlgConfirm.content, {
				title: jsDlgConfirm.title,
				buttons: {
					'OK': function() {
						jTien.callJqDialog(jsDlgConfirm.id, url);
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

$('#user_list_pagelet').ready(function() {
	var filterForm = '#user-filter-form',
		filterSubmit = '#filter-query-submit',
		lnkShowAll =  '#lnkShowAll',
		resultList = '#the-list';
	$(filterForm).delegate(filterSubmit, 'click', function(evt) {
		jTien.ajaxConnect(resultList, filterForm)
				.success(function(data) {
					if (data == null || data.length == 0) {
						$(resultList).html('<tr><td colspan="9">Nothing to show.</td></tr>');
					}
				});
	});
	$(filterForm).delegate(lnkShowAll, 'click', function() {
		jTien.ajaxConnect(resultList, filterForm, 'q=&f=0');
	});
});