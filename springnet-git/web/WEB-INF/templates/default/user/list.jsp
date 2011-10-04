<%@ include file="../layout/top.inc"%><%@ include file="../layout/header.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style>
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<script>
$(function() {
	$('#btnSearch').click(function() {
		jTien.ajaxConnect('search-container', 'user-search-form')
				.success(function(data) {
					if (data == null || data.length == 0) {
						$('#search-container').html('Nothing to show.');
					}
				});
	});
	$('#lnkShowAll').click(function() {
		jTien.ajaxConnect('search-container', 'user-search-form', 'q=');
	});
});
</script>

<form id="user-search-form" method="post" action="/user/search">
	<input type="text" id="txtSearch" name="q" />
	<input type="button" id="btnSearch" value="Search" />
	<a id="lnkShowAll" href="javascript:">Show All</a>
</form>
<div id="search-container">
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
</div>

</compress:html>
<%@ include file="../layout/footer.inc"%>