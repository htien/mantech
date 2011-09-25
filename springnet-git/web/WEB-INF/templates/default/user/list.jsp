<%@ include file="../layout/top.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style>
	.grid {border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<h1>List of user</h1>
<table class = "grid">
	<tr>
		<th colspan = "9">List of Users</th>
	</tr>
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
	<c:forEach items="${listUser}" var="l">
		<tr>
			<td>${l.username}</td>
			<td>${l.role.name}</td>
			<td>${l.department.name}</td>
			<td>${l.firstName}</td>
			<td>${l.lastName}</td>
			<td>${l.gender}</td>
			<td>${l.homeAddress}</td>
			<td>${l.status}</td>
			<td>${l.regDate }</td>
		</tr>
	</c:forEach>
</table>

</compress:html>
<%@ include file="../layout/footer.inc"%>