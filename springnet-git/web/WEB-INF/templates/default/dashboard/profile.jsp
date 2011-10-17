<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="profile-tabs">
	<ul>
		<li><a href="#profile-basic">Basic Infomation</a></li>
		<li><a href="#profile-changepwd">Change Password</a></li>
		<li><a href="#">Under Construction</a></li>
	</ul>
	<div id="profile-basic">
		<table class="grid">
			<tr>
				<td class="label">ID:</td>
				<td><strong>${user.id}</strong></td>
			</tr>
			<tr>
				<td class="label">Username:</td>
				<td><strong>${user.username}</strong></td>
			</tr>
			<tr>
				<td class="label">Full Name: </td>
				<td><strong>${user.firstName} ${user.lastName}</strong></td>
			</tr>
			<tr>
				<td class="label">Gender: </td>
				<td><strong>
					<c:if test="${user.gender == 'M'}">Male</c:if>
					<c:if test="${user.gender == 'F'}">Female</c:if>
				</strong></td>
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td><strong>${user.homeAddress}</strong></td>
			</tr>
			<tr>
				<td class="label">Status:</td>
				<td><strong>${user.status}</strong></td>
			</tr>
			<tr>
				<td class="label">Join Date:</td>
				<td><strong>${user.regDate}</strong></td>
			</tr>
		</table>
		<div class="buttons">
			<div id="close-profile" class="g-b g-b-b">Close</div>
		</div>
	</div>
	<div id="profile-changepwd">
		<form id="changepass-form" class="g-f" method="post" action="/user/changepass">
			<p>To reset your password, provide your current password.</p>
			<table class="grid">
				<tr>
					<td class="label">Current password: </td>
					<td><input type="password" name="oldpass" size="30" /></td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr>
					<td class="label">New password: </td>
					<td><input type="password" name="newpass" size="30" /></td>
				</tr>
				<tr>
					<td class="label">Confirm new password: </td>
					<td><input type="password" name="confirmpass" size="30" /></td>
				</tr>
			</table>
			<div class="buttons">
				<div id="change-passwd" class="g-b g-b-r">Save</div>
				<div id="close-profile2" class="g-b g-b-b">Close</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	var frm = null,
		dialogOpts = {
			title: 'Change Password Confirmation',
			buttons: {
				'OK': function() {
					if(!frm.valid()) { return; }
					jTien.ajaxSubmit(frm)
						.success(function(data, textCode, xhr) {
							if (data.status == 1) {
							}
							jTien.resetForm(frm);
							jTien.callJqDialog('ajax-response', data.message);
						});
				},
				'Cancel': function() {
					$(this).dialog('destroy');
				}
			}
		},
		validOpts = {
			rules: {
				oldpass: { required: true },
				newpass: { required: true, minlength: 6 },
				confirmpass: { required: true, minlength: 6 }
			},
			messages: {
				oldpass: {
					required: ''
				},
				newpass: {
					required: '',
					minlength: 'At least {0} characters.'
				},
				confirmpass: {
					required: '',
					minlength: 'At least {0} characters.'
				}
			},
			submitHandler: function(form) {
				var dlg = jTien.callJqDialog('ajax-response',
						'Are you sure you want to change your password?', dialogOpts);
				dlg.dialog('open');
			}
		};

	$('#close-profile').live('click', function(evt) {
		$('#ajax-response').dialog('close');
	});

	$('#close-profile2').live('click', function(evt) {
		$('#close-profile').click();
	});

	$('#change-passwd').live('click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
</script>

</compress:html>