<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<style>
	#profile-tabs .grid td { padding: 7px; vertical-align: middle; }
	#profile-tabs .grid .label { text-align: right; }
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
				<td>ID: </td>
				<td><strong>${user.id}</strong></td>
			</tr>
			<tr>
				<td>Username: </td>
				<td><strong>${user.username}</strong></td>
			</tr>
			<tr>
				<td>First Name: </td>
				<td><strong>${user.firstName}</strong></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><strong>${user.lastName}</strong></td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td><strong>${user.gender}</strong></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><strong>${user.homeAddress}</strong></td>
			</tr>
			<tr>
				<td>Status: </td>
				<td><strong>${user.status}</strong></td>
			</tr>
			<tr>
				<td>Join Date: </td>
				<td><strong>${user.regDate}</strong></td>
			</tr>
			<tr>
				<td><div id="close-profile" class="g-b g-b-b">Close</div></td>
			</tr>
		</table>
	</div>
	<div id="profile-changepwd">
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
			<tr>
				<td class="buttons" colspan="2"><div id="change-profile" class="g-b g-b-b">Change</div></td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	$('#close-profile').live('click', function(evt) {
		$('#ajax-response').dialog('close');
		$('#close-personal-menu').click();
	});
</script>

</compress:html>