$('#adduser_pagelet').ready(function() {
	var frm = null;
	var dialogOpts = {
		title: "Add User Confirmation",
		buttons: {
			'Create': function() {
				if (frm.valid()) {
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							jTien.callJqDialog('confirm-dialog', 'Added user successfully!', {
								title: 'Server Message',
								buttons: {
									Close: function() {
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
				}
			},
			'Cancel': function() {
				$(this).dialog("destroy");
			}
		}
	};

	var validOpts = {
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
				email:'eg, abc@cba.com'
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
			var dlg = jTien.callJqDialog('confirm-dialog', $ctx+ '/user.cfm',
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