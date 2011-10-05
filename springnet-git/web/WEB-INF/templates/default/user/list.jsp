<%@ include file="../layout/top.inc"%><%@ include file="../layout/header.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style>
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<script>
$(function() {
	$('#btnSearch').click(function() {
		jTien.ajaxConnect('the-list', 'user-filter-form')
				.success(function(data) {
					if (data == null || data.length == 0) {
						$('#search-container').html('Nothing to show.');
					}
				});
	});
	$('#lnkShowAll').click(function() {
		jTien.ajaxConnect('the-list', 'user-filter-form', 'q=&yourChoice=0');
	});
});
</script>

<form id="user-filter-form" method="post" action="/user/search">
	<input type="text" name="q" />
	<select name="yourChoice">
		<option value="0">All</option>
		<option value="1">UserName</option>
		<option value="2">Department</option>
	</select>
	<input type="button" id="btnSearch" value="Search" />
	<a id="lnkShowAll" href="javascript:">Show All</a>
</form>

<div id="user_list_pagelet" class="g-pl">
	<table class="gg-list-table users grid">
		<thead>
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
		</thead>
		<tfoot>
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
		</tfoot>
		<tbody id="the-list">
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
				<td>${user.regDate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

</compress:html>
<%@ include file="../layout/footer.inc"%>