<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_user_list" class="g-pl wrap">
	<h2>Users<a class="add-new-h2" href="<jtien:url address="/index"/>#adduser">Add New</a></h2>
	<ul class="subsubsub">
		<li class="all">All <span class="count">(0)</span> | </li>
		<li class="deleted">Deleted <span class="count">(0)</span></li>
	</ul>
	<form id="user-filter-form" method="post" action="/user/search">
		<div class="tablenav"></div>
		<input type="text" name="q" />
		<select name="f">
			<option value="1">UserName</option>
			<option value="2">Department</option>
		</select>
		<div id="filter-query-submit" class="g-b g-b-r">Filter</div>
		<div id="lnkShowAll" class="g-b g-b-b">Show All</div>
		
		<div id="user-viewmanager">
			<div class="gg-listview">
				<div class="gg-listview-inner">
					<div class="gg-listview-headers-container">
						<table class="gg-list-table gg-list-header-table widefat fixed user">
							<colgroup>
								<col class="list-col-userid" width="70" />
								<col class="list-col-username" />
								<col class="list-col-role" width="100" />
								<col class="list-col-department" />
								<col class="list-col-fullname" />
								<col class="list-col-gender" width="65" />
								<col class="list-col-status" width="80" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">User ID</span></td>
									<td><span class="gg-inner-block">Username</span></td>
									<td><span class="gg-inner-block">Role</span></td>
									<td><span class="gg-inner-block">Department</span></td>
									<td><span class="gg-inner-block">Full Name</span></td>
									<td><span class="gg-inner-block">Gender</span></td>
									<td><span class="gg-inner-block">Status</span></td>
								</tr>
							</thead>
							<tbody><tr><td colspan="7"></td></tr></tbody>
						</table>
					</div>
					<div class="gg-listview-list">
						<div class="gg-list-container">
							<table class="gg-list-table widefat fixed user">
								<colgroup>
									<col class="list-col-userid" width="70" />
									<col class="list-col-username" />
									<col class="list-col-role" width="100" />
									<col class="list-col-department" />
									<col class="list-col-fullname" />
									<col class="list-col-gender" width="65" />
									<col class="list-col-status" width="80" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="height:0"></tr>
								</thead>
								<tbody id="the-list" class="gg-list-tbody">
									<%@ include file="user_list_result.jsp" %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="clear"></div>
</div>
</compress:html>