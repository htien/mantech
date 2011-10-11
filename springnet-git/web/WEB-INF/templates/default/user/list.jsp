<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style type="text/css">
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<div id="pagelet_user_list" class="g-pl">
	<form id="user-filter-form" method="post" action="/user/search">
		<input type="text" name="q" />
		<select name="f">
			<option value="1">UserName</option>
			<option value="2">Department</option>
		</select>
		<div id="filter-query-submit" class="g-b g-b-r">Filter</div>
		<div id="lnkShowAll" class="g-b g-b-b">Show All</div>
		<table class="gg-list-table users grid">
			<thead><tr><th>Id</th><th>Username</th><th>Role</th><th>Deparment</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Address</th><th>Status</th><th>Register Date</th><th>Edit</th></tr></thead>
			<tfoot><tr><th>Id</th><th>Username</th><th>Role</th><th>Deparment</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Address</th><th>Status</th><th>Register Date</th><th>Edit</th></tr></tfoot>
			<tbody id="the-list">
				<%@ include file="user_list_result.jsp" %>
			</tbody>
		</table>
	</form>
</div>

</compress:html>