<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<table class="grid">
	<tr>
		<th>Username</th>
		<th>Role</th>
		<th>Deparment</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Address</th>
		<th>Status</th>
		<th>Register Date</th>
	</tr>
	<c:forEach items="${listUser}" var="user">
		<tr>
			<td>${user.username}</td>
			<td>${user.role.name}</td>
			<td>${user.department.name}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.gender}</td>
			<td>${user.homeAddress}</td>
			<td>${user.status}</td>
			<td>${user.regDate}</td>
		</tr>
	</c:forEach>
</table>

</compress:html>