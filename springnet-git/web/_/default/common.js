/* === Document Ready for assigning events === */

$(function() {
	if ($('body').hasClass('gg-admin')) {
		ajaxPageload();
		applyAjax_adminmenu();
		applyAjax_pagelet();
		jTien.adminMenu.init();

		ggAdminBar_applyMenuPopup();
		$('#lnkOptions').click(openOptionsPopup);
		$('#close-personal-menu').click(closePersonalMenu);
		$('#profile').click(profileHandler);
		$('#signout').click(signoutHandler);
		$('#new-complaint').click(openNewComplaintPage);
	}
});

ggAdminBar_applyMenuPopup = function() {
	var menuItems = $('#ggadminbar li.gg-menupop');
	menuItems.find('.ggl').each(function(idx, el) {
		$(this).click(ggAdminBar_openMenuPopup);
	});
},

ggAdminBar_openMenuPopup = function(evt) {
	var ggl = $(this),
		menuItem = ggl.parent(),
		popContainer = ggl.siblings('div.gg-menupop');
	if (popContainer.is(':hidden')) {
		var openClass = 'gg-menupop-open';
		ggl.addClass(openClass);
		menuItem.addClass(openClass);
		popContainer.show('fast');
	}
	return false;
},

ggAdminBar_closeMenuPopup = function(popMenu) {
	if (popMenu.is(':visible')) {
		var openClass = 'gg-menupop-open',
			menuItem = popMenu.parents('li.' + openClass);
		popMenu.hide('fast');
		menuItem.removeClass(openClass);
		menuItem.find('.' + openClass).removeClass(openClass);
	}
},

closePersonalMenu = function(evt) {
	ggAdminBar_closeMenuPopup($('#gg-personal-menu'));
},

openOptionsPopup = function(evt) {
	var notice = 'This function is temporarily not allowed. It will be released in version 2.0.';
	jTien.callJqDialog('ajax-response', notice).dialog('open');
	return false;
},

profileHandler = function(evt) {
	var url = jTien.url('/user') + '?action=profile',
		dialog = jTien.callJqDialog('userprofile-dialog', url, {
			title: 'Mantech Profile',
			width: 600,
			buttons: {}
		});
	$('#profile-tabs').tabs();
	jTien.f.completeFormAction();
	dialog.dialog('open');
	$('#close-personal-menu').click();
},

signoutHandler = function(evt) {
	var link = $(this).attr('href');
	jTien.callJqDialog('ajax-response', 'Please confirm the logout?', {
		title: 'Logout Confirmation',
		buttons: {
			'OK': function() {
				document.location = link;
			},
			'Cancel': function() {
				$(this).dialog('destroy');
				$('#close-personal-menu').click();
			}
		}
	}).dialog('open');
	return false;
},

openNewComplaintPage = function() {
//	var link = jTien.url('/index').concat('#addcomplaint');
//	jTien.ajaxFromLink(link, jTien.url('/loader'), '#ggbody-content')
//			.success(function(html) {
//				applyAjax_pagelet();
//			});
	$('#addcomplaint').click();
};

$('#pagelet_signin').ready(function() {

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
				passwd: { required: true, minlength: 1 }
			},
			messages: {
				id: { required: 'Enter your username or email.', minlength: 'ID, at least {0} characters.' },
				passwd: { required: 'Enter your password.', minlength: 'Password, at least {0} characters.' }
			},
			invalidHandler: function(form, validator) {
				shakeContainer(signInBox);
			},
			submitHandler: function(form) {
				jTien.ajaxSubmit(form)
					.success(function(loginResponse) {
						if (loginResponse.status == 1) { 
							document.location = jTien.url('/index');
						}
						else {
							jTien.callJqDialog('ajax-response', loginResponse.message, {
								buttons: {
									'Close': function() {
										$(this).dialog('destroy');
										jTien.resetForm(signInForm);
										$(signInForm).submit();
									}
								}
							}).dialog('open');
						}
					})
					.error(function(data) {
						jTien.resetForm(signInForm);
					});
			}
		});
		
		$(signInForm).submit();
		return false;
	});
	
});

$('#pagelet_signin #testZone').ready(function() {
	
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

$('#pagelet_listuser').ready(function() {
	var filterForm = '#user-filter-form',
		filterSubmit = '#filter-query-submit',
		lnkShowAll =  '#lnkShowAll',
		resultList = '#the-list';
	$(filterSubmit).live('click', function(evt) {
		jTien.ajaxConnect(resultList, filterForm)
				.success(function(data) {
					if (data == null || data.length == 0) {
						$(resultList).html('<tr><td colspan="9" style="padding-top:5px;text-align:center">Nothing to show.</td></tr>');
					}
				});
	});
	$(lnkShowAll).live('click', function() {
		jTien.ajaxConnect(resultList, filterForm, 'q=&f=0');
	});
});