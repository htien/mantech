<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<style>
  #profile-tabs .grid { width: 100%; }
  #profile-tabs .grid td { padding: 7px; vertical-align: middle; }
  #profile-tabs .grid .label { text-align: right; }
  #profile-tabs .buttons { margin-top: 15px; }
  #profile-basic .grid td { border-bottom: 1px dotted #eee; }
  #profile-basic .label { width: 100px; }
  #profile-changepwd .label { width: 150px; }
</style>

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
				<td><strong><c:if test="${user.gender} == 'M'">Male</c:if>Female</strong></td>
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
			<table class="grid">
				<tr>
					<td class="label">Current Password: </td>
					<td><input type="password" name="oldpass" size="30" /></td>
				</tr>
				<tr>
					<td class="label">New Password: </td>
					<td><input type="password" name="newpass" size="30" /></td>
				</tr>
				<tr>
					<td class="label">Confirm New Password: </td>
					<td><input type="password" name="confirmpass" size="30" /></td>
				</tr>
			</table>
			<div class="buttons">
				<div id="change-passwd" class="g-b g-b-b">Save</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	var frm = null,
	validOpts = {
		rules: {
			oldpass: {required: true, minlength: 6},
			newpass: {required: true, minlength: 6},
			confirmpass: {required: true, minlength: 6}
		},
		messages: {
			oldpass: {
				required: '',
				minlength: 'Please enter at least {0} characters.'
			},
			newpass: {
				required: '',
				minlength: 'Please enter at least {0} characters.'
			},
			confirmpass: {
				required: '',
				minlength: 'Please enter at least {0} characters.'
			}
		},
		submitHandler: function(form) {
			var dlg = jTien.callJqDialog('ajax-response', 'Are you sure you want to change your password?',
					dialogOpts);
			dlg.dialog('open');
		}
	};	
	$('#close-profile').live('click', function(evt) {
		$('#ajax-response').dialog('close');
	});
	$('#change-passwd').live('click', function(evt) {
		frm = $(this).parents('form');
		frm.validate(validOpts);
		frm.submit();
	});
</script>

</compress:html>