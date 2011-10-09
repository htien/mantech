$('#adduser_pagelet').ready(function() {
	var frm = null,
		dialogOpts = {
			title: 'Add User Confirmation',
			buttons: {
				'Create': function() {
					if (!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							if (data.status == 1) {
								jTien.callJqDialog('ajax-response', data.message, {
									buttons: {
										'Close': function() {
											$(this).dialog('destroy');
										}
									}
								});
								jTien.resetForm(frm);
							}
							if (data.status == 0) {
								jTien.callJqDialog('ajax-response', data.message, {
									buttons: {
										'Close': function() {
											$(this).dialog('destroy');
										}
									}
								});
							}
						})
						.error(function(data) {
							alert(data);
							$(dialog).dialog('close');
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
			rules: {
				username: { required:true, minlength:3, maxlength:16 },
				passwd: { required:true, minlength:6 },
				email: { required:true, email:true },
				firstName: { required:true, minlength:3, maxlength:30 },
				lastName: { required:true, minlength:3, maxlength:30 },
				address: { required:true, minlength:3, maxlength:200 }
			},
			messages: {
				username: {
					required: '',
					minlength: 'Please enter at least {0} characters.',
					maxlength: 'Please enter no more than {0} characters.'
				},
				passwd: {
					required: '',
					minlength: 'Please enter at least {0} characters.'
				},
				email: {
					required: '',
					email:'eg, yourname@example.com'
				},
				firstName: {
					required: '',
					minlength: 'Please enter at least {0} characters.',
					maxlength: 'Please enter no more than {0} characters.'
				},
				lastName: {
					required: '',
					minlength: 'Please enter at least {0} characters.',
					maxlength: 'Please enter no more than {0} characters.'
				},
				address: {
					required: '',
					minlength: 'Please enter at least {0} characters.',
					maxlength: 'Please enter no more than {0} characters.'
				}
			},
			submitHandler: function(form) {
				var dlg = jTien.callJqDialog('ajax-response', 'Are you sure you want to add new user?',
						dialogOpts);
				dlg.dialog('open');
			}
		};
	
	$('#adduser-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#adduser-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#addcomplaint_pagelet').ready(function() {
	var frm = null,
		dialogOpts = {
			title: 'Add Complaint Confirmation',
			buttons: {
				'Create': function() {
					if (!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							if (data.status == 1) {
								jTien.callJqDialog('ajax-response', data.message, {
									buttons: {
										'Close': function() {
											$(this).dialog('destroy');
										}
									}
								});
								jTien.resetForm(frm);
							}
						})
						.error(function(data) {
							$(dialog).dialog('close');
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
			rules: {
				title: { required: true },
				content: { required: true }
			},
			messages: {
				title: { required: '' },
				content: { required: '' }
			},
			submitHandler: function(form) {
				jTien.callJqDialog('ajax-response', 'Are you sure you want to add new complaint?', 
						dialogOpts).dialog('open');
			}
		};
	
	$('#addcomplaint-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#addcomplaint-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#addassignment_pagelet').ready(function() {
	var frm = null,	
		dialogOpts = {
			title: 'Add Assignment Confirmation',
			buttons: {
				'Create': function() {
					if (!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							jTien.callJqDialog('ajax-response', 'Added assignment successfully!', {
								buttons: {
									'Close': function() {
										$(this).dialog('destroy');
									}
								}
							});
							$('#msg').html(xhr.responseText);
							jTien.resetForm(frm);
						})
						.error(function(data) {
							$(dialog).dialog('close');
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
				rules: {
					beginDate: {
						required: true,
						vietnameseDate: true
					},
					duration: {
						required: true,
						digits: true
					},
					userId: {
						required: true
					}
				},
				messages: {
					beginDate: {
						required: '',
						vietnameseDate: 'yyyy/MM/dd'
					},
					duration: {
						required: '',
						digits: 'Must a positive number'
					},
					userId: {
						required: 'Please choose the technician to assign!'
					}
				},
				submitHandler: function(form) {
					var dlg = jTien.callJqDialog('ajax-response', 'Are you sure you want to add new complaint?', 
							dialogOpts);
					dlg.dialog('open');
				}
		};
	
	$('#addassignment-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#addassignment-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#addequipment_pagelet').ready(function() {
	var frm = null,
		dialogOpts = {
				title: 'Add Equipment Confirmation',
				buttons: {
					'Create': function() {
						if (!frm.valid()) { return; }
						jTien.ajaxSubmit(frm)
							.success(function(data, textCode, xhr) {
								jTien.callJqDialog('ajax-response', 'Added equipment successfully', {
									buttons: {
										'Close': function() {
											$(this).dialog('destroy');
										}
									}
								});
								$("#msg").html(xhr.responseText);
								jTien.resetForm(frm);
							})
							.error(function(data) {
								alert('error');
								$(dialog).dialog('close');
							});
					},
					'Cancel': function() {
						$(this).dialog('destroy');
					}
				}
		},
		validOpts = {
			rules: {
				name: { required: true }
			},
			messages: {
				name: { required: '' }
			},
			submitHandler: function(form) {
				jTien.callJqDialog('ajax-response', 'Are you sure you want to add new equipment?', dialogOpts)
						.dialog('open');
			}
		};
	
	$('#addequipment-box').delegate('#btnAdd', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
	$('#addequipment-box').delegate('#btnReset', 'click', function(evt) {
		jTien.resetForm($(this).parents('form'));
	});
});

$('#edituser_pagelet').ready(function() {
	var frm = null,
		dialogOpts = {
				title: 'Edit User Confirmation',
				buttons: {
					'Update': function() {
						if (!frm.valid()) { return; }
						jTien.ajaxSubmit(frm)
							.success(function(json, textCode, xhr) {
								if (json.status == 1) {
									jTien.callJqDialog('ajax-response', json.message, {
										buttons: {
											'Close Message': function() {
												$(this).dialog('destroy');
											}
										}
									});
								}
							});
					},
					'Cancel': function() {
						$(this).dialog('destroy');
					}
				}
		},
		validOpts = {
			rules: {
				email: { required: true,email: true },
				address: { required:true, minlength:3, maxlength:200 }
			},
			messages: {
				email: {
					required: '',
					email:'eg, abc@cba.com'
				},
				address: {
					required: '',
					minlength: 'Please enter at least {0} characters.',
					maxlength: 'Please enter no more than {0} characters.'
				}
			},
			submitHandler: function(form) {
				jTien.callJqDialog('ajax-response', 'Are you sure you want to edit this user?', dialogOpts).dialog('open');
			}
		};
	
	$('#edituser-box').delegate('#btnEdit', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
});

$('#editcomplaint_pagelet').ready(function() {
	var frm = null,
	
	dialogOpts = {
		title: 'Edit Complaint Confirmation',
		buttons: {
			'Update': function() {
				if (!frm.valid()) {return;}
				jTien.ajaxSubmit(frm)
					.success (function(json, textCode, xhr) {
						jTien.callJqDialog('ajax-response', json.message, {
							buttons: {
								'Close Message': function() {
									$(this).dialog('destroy');
								}
							}
						});
					});
			},
			'Cancel': function() {
				$(this).dialog('destroy');
			}
		}
	},
	
	validOpts = {
		submitHandler: function(form) {
			jTien.callJqDialog('ajax-response', 'Are you sure want to edit this complaint?', dialogOpts).dialog('open');
		}	
	};
	
	$('#editcomplaint-box').delegate('#btnEdit', 'click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
});

$('#complaint_list_pagelet').ready(function() {
	var filterForm = '#complaint-filter-form',
		filterSubmit = '#filter-query-submit',
		lnkShowAll = '#lnkShowAll',
		resultList = '#the-list';
	
	$(filterForm).delegate(filterSubmit, 'click', function(evt) {
		var dateFrom = $('#dateFrom').val().trim(),
			dateTo = $('#dateTo').val().trim(),
			status = $('#status').val(),
			priority = $('#priority').val();
		var data = 'q=' + $('#query').val() + '&f=' + $('#field-name').val();
		data += dateFrom.length != 0 ? '&dateFrom=' + dateFrom : '';
		data += dateTo.length != 0 ? '&dateTo=' + dateTo : '';
		data += '&status=' + status;
		data += '&priority=' + priority;
		jTien.ajaxConnect(resultList, filterForm, data)
			.success(function(data) {
				if (data == null || data.length == 0) { 
					$(resultList).html('<tr><td colspan="9">Nothing to show.</td></tr>');
				}
			});	
	});
	$(filterForm).delegate(lnkShowAll, 'click', function(evt) {
		jTien.ajaxConnect(resultList, filterForm, 'q=&f=0&status=0&priority=0');
	});
});
