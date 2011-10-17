<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div class="demo">
	<div id="tabs">
		<ul>
			<li><a href="#tab-1">Basic Infomation</a></li>
			<li><a href="#tab-2">Change Password</a></li>
			<li><a href="#tab-1">Under Construction</a></li>
		</ul>
		<div id="tab-1">
			<div><h2>Basic Infomation</h2></div>
			<div><strong>ID: </strong>${user.id}</div>
			<div><strong>UserName: </strong>${user.username}</div>
			<div><strong>First Name: </strong>${user.firstName}</div>
			<div><strong>Last Name: </strong>${user.lastName}</div>
			<div><strong>Gender: </strong>${user.gender}</div>
			<div><strong>Address: </strong>${user.homeAddress}</div>
			<div><strong>Status: </strong>${user.status}</div>
			<div><strong>Join Date: </strong>${user.regDate}</div>	
		</div>
		<div id="tab-2">
			<div><h2>Change Password</h2></div>
			<div><strong>Current Password: </strong><input type="password" name="oldpass" width="30px"/></div>
			<div><strong>New Password: </strong><input type="password" name="newpass" width="30px"/></div>
			<div><strong>Confirm New Password: </strong><input type="password" name="confirmpass" width="30px"/></div>
		</div>
	</div>
</div>
<script>
	$('#tabs').tabs();
</script>

</compress:html>