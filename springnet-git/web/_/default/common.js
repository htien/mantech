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

buildJqDialogOpts = function(targetForm, title) {
	return {
		title: title,
		buttons: {
			'OK': function(evt) {
				if (!targetForm.valid()) {
					return;
				}
				jTien.ajaxSubmit(targetForm)
						.success(function(json, textCode, xhr) {
							jTien.callJqDialog($defaultDlgId, json.message, {
								buttons: {
									'Close': function() {
										$(this).dialog('destroy');
									}
								}
							});
							
							// reset form after adding successfully
							if (json.name == 'add' && json.status == '1') {
								jTien.resetForm(targetForm);
							}
						})
						.error(function(data) {
							$(this).dialog('destroy');
						});
			},
			'Cancel': function() {
				$(this).dialog('destroy');
			}
		}
	};
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


/*=== PAGELET ===*/

$(function() {

	var pagelet_listuser = '#pagelet_listuser', pagelet_adduser = '#pagelet_adduser', pagelet_edituser = '#pagelet_edituser',
		pagelet_addcategory = '#pagelet_addcategory', pagelet_editcategory = '#pagelet_editcategory',
		pagelet_addequipment = '#pagelet_addequipment', pagelet_editequipment = '#pagelet_editequipment',
		pagelet_listcomplaint = '#pagelet_listcomplaint', pagelet_addcomplaint = '#pagelet_addcomplaint', pagelet_editcomplaint = '#pagelet_editcomplaint',
		pagelet_listequipment = '#pagelet_listequipment', pagelet_addassignment = '#pagelet_addassignment'
		;
	var _userlist_filterForm = '#user-filter-form', _userlist_filterSubmit = '#filter-query-submit', _userlist_lnkShowAll =  '#lnkShowAll', _userlist_resultList = '#the-list',
		_useradd_btnAdd = '#btnAdd', _useradd_btnReset = '#btnReset',
		_useredit_btnEdit = '#btnEdit',
		_categorylist_filterForm = '#category-filter-form',
		_categoryadd_btnAdd = '#btnAdd', _categoryadd_btnReset = '#btnReset',
		_categoryedit_btnEdit = '#btnEdit',
		_equipmentlist_filterForm = '#equipment-filter-form', _equipmentlist_filterSubmit = '#filter-query-submit', _equipmentlist_resultList = '#the-list';
		_equipmentadd_btnAdd = '#btnAdd', _equipmentadd_btnReset = '#btnReset',
		_equipmentedit_btnEdit = '#btnEdit',
		_complaintlist_filterForm = '#complaint-filter-form', _complaintlist_filterSubmit = '#filter-query-submit', _complaintlist_resultList = '#the-list',
		_complaintadd_btnAdd = '#btnAdd', _complaintadd_btnReset = '#btnReset',
		_complaintedit_btnEdit = '#btnEdit',
		_assignmentadd_btnAdd = '#btnAdd', _assignmentadd_btnReset = '#btnReset'
		;

	$(_userlist_filterSubmit, pagelet_listuser).live('click', function(evt) {
		jTien.ajaxConnect(_userlist_resultList, _userlist_filterForm)
				.success(function(data) {
					if (data == null || data.length == 0) {
						$(_userlist_resultList).html('<tr><td colspan="9" style="padding-top:5px;text-align:center">No data to show.</td></tr>');
					}
				});
	});

	$(_userlist_lnkShowAll, pagelet_listuser).live('click', function(evt) {
		jTien.ajaxConnect(_userlist_resultList, _userlist_filterForm, 'q=&f=0');
	});
	
	$(_useradd_btnAdd, pagelet_adduser).live('click', function(evt) {
		var _useradd_form = $(this).parents('form'),
			_useradd_dialogOpts = buildJqDialogOpts(_useradd_form, 'Add User Confirmation'),
			_useradd_validOpts = {
				rules: {
					username: { required:true, minlength:3, maxlength:16 },
					passwd: { required:true, minlength:6 },
					confirm_passwd: { required: true, equalTo: "#password" },
					email: { required:true, email:true },
					firstName: { required:true, minlength:1, maxlength:30 },
					lastName: { required:true, minlength:1, maxlength:30 },
					address: { required:true, minlength:1, maxlength:200 }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure you want to add new user?',
							_useradd_dialogOpts).dialog('open');
				}
			};

		_useradd_form.validate(_useradd_validOpts);
		_useradd_form.submit();
	});

	$(_useradd_btnReset, pagelet_adduser).live('click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
	
	$(_useredit_btnEdit, pagelet_edituser).live('click', function(evt) {
		var _useredit_form = $(this).parents('form'),
			_useredit_dialogOpts = buildJqDialogOpts(_useredit_form, 'Edit User Confirmation'),
			_useredit_validOpts = {
				rules: {
					email: { required: true, email: true },
					address: { required: true, minlength: 3, maxlength: 200 }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure you want to edit this user?',
							_useredit_dialogOpts).dialog('open');
				}
			};
		
		_useredit_form.validate(_useredit_validOpts);
		_useredit_form.submit();
	});
	
	$(_categoryadd_btnAdd, pagelet_addcategory).live('click', function(evt) {
		var _categoryadd_form = $(this).parents('form'),
			_categoryadd_dialogOpts = buildJqDialogOpts(_categoryadd_form, 'Add category Confirmation'),
			_categoryadd_validOpts = {
				rules: {
					name: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure you want to add new category?',
							_categoryadd_dialogOpts).dialog('open');
				}
			};
		
		_categoryadd_form.validate(_categoryadd_validOpts);
		_categoryadd_form.submit();
	});
	
	$(_categoryadd_btnReset, pagelet_addcategory).live('click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
	
	$(_categoryedit_btnEdit, pagelet_editcategory).live('click', function(evt) {
		var _categoryedit_form = $(this).parents('form'),
			_categoryedit_dialogOpts = buildJqDialogOpts(_categoryedit_form, 'Edit Category Confirmation'),
			_categoryedit_validOpts = {
				rules: {
					name: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure want to edit this category?',
							_categoryedit_dialogOpts).dialog('open');
				}
			};
	
		_categoryedit_form.validate(_categoryedit_validOpts);
		_categoryedit_form.submit();
	});
	
	$(_equipmentlist_filterSubmit, pagelet_listequipment).live('click', function(evt) {
		jTien.ajaxConnect(_equipmentlist_resultList, _equipmentlist_filterForm)
				.success(function(html) {
					if (html == null || html.length == 0) {
						$(_equipmentlist_resultList).html('<tr><td colspan="3" style="padding-top:5px;text-align:center">No data to show.</td></tr>');
					}
				});
	});
	
	$(_equipmentadd_btnAdd, pagelet_addequipment).live('click', function(evt) {
		var _equipmentadd_form = $(this).parents('form'),
			_equipmentadd_dialogOpts = buildJqDialogOpts(_equipmentadd_form, 'Edit Equipment Confirmation'),
			_equipmentadd_validOpts = {
				rules: {
					name: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure you want to add new equipment?',
							_equipmentadd_dialogOpts).dialog('open');
				}
			};

		_equipmentadd_form.validate(_equipmentadd_validOpts);
		_equipmentadd_form.submit();
	});
	
	$(_equipmentadd_btnReset, pagelet_addequipment).live('click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
	
	$(_equipmentedit_btnEdit, pagelet_editequipment).live('click', function(evt) {
		var _equipmentadd_form = $(this).parents('form'),
			_equipmentedit_dialogOpts = buildJqDialogOpts(_equipmentadd_form, 'Edit Category Confirmation'),
			_equipmentedit_validOpts = {
				rules: {
					name: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure want to edit this equipment?',
							_equipmentedit_dialogOpts).dialog('open');
				}
			};
	
		_equipmentadd_form.validate(_equipmentedit_validOpts);
		_equipmentadd_form.submit();
	});
	
	$(_complaintlist_filterSubmit, pagelet_listcomplaint).live('click', function(evt) {
		var dateFrom = $('#dateFrom').val().trim(),
			dateTo = $('#dateTo').val().trim(),
			status = $('#status').val(),
			priority = $('#priority').val(),
			data = 'q=' + $('#query').val() + '&f=' + $('#field-name').val()
					+ (dateFrom.length != 0 ? '&dateFrom=' + dateFrom : '')
					+ (dateTo.length != 0 ? '&dateTo=' + dateTo : '')
					+ '&status=' + status
					+ '&priority=' + priority;

		jTien.ajaxConnect(_complaintlist_resultList, _complaintlist_filterForm, data)
				.success(function(html) {
					if (html == null || html.length == 0) { 
						$(_complaintlist_resultList).html('<tr><td colspan="7">No data to show.</td></tr>');
					}
				});
	});
	
	$(_complaintadd_btnAdd, pagelet_addcomplaint).live('click', function(evt) {
		var _complaintadd_form = $(this).parents('form'),
			_complaintadd_dialogOpts = buildJqDialogOpts(_complaintadd_form, 'Add Complaint Confirmation'),
			_complaintadd_validOpts = {
				rules: {
					complaint_title: { required: true },
					complaint_content: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDlgId, 'Are you sure you want to add new complaint?', 
							_complaintadd_dialogOpts).dialog('open');
				}
			};

		_complaintadd_form.validate(_complaintadd_validOpts);
		_complaintadd_form.submit();
	});

	$(_complaintadd_btnReset, pagelet_editcomplaint).live('click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
	
	$(_complaintedit_btnEdit, pagelet_editcomplaint).live('click', function(evt) {
		var _complaintedit_form = $(this).parents('form'),
			_complaintedit_dialogOpts = buildJqDialogOpts(_complaintedit_form, 'Edit Complaint Confirmation'),
			_complaintedit_validOpts = {
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDialogId, 'Are you sure want to edit this complaint?',
							_complaintedit_dialogOpts).dialog('open');
				}	
			};

		_complaintedit_form.validate(_complaintedit_validOpts);
		_complaintedit_form.submit();
	});
	
	$(_assignmentadd_btnAdd, pagelet_addassignment).live('click', function(evt) {
		var _assignmentadd_form = $(this).parents('form'),
			_assignmentadd_dialogOpts = buildjqDialogOpts(_assignmentadd_form, 'Added assignment successfully.'),
			_assignmentadd_validOpts = {
				rules: {
					beginDate: { required: true, vietnameseDate: true },
					duration: { required: true, digits: true },
					userId: { required: true }
				},
				submitHandler: function(form) {
					jTien.callJqDialog($defaultDialogId, 'Are you sure you want to add new assignment?', 
							_assignmentadd_dialogOpts).dialog('open');
				}
			};

		_assignmentadd_form.validate(_assignmentadd_validOpts);
		_assignmentadd_form.submit();
	});
	
	$(_assignmentadd_btnReset, pagelet_addassignment).live('click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});

});
