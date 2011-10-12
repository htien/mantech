<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="complaint_list_pagelet" class="g-pl wrap">
	<h2>Complaints<a class="add-new-h2" href="<jtien:url address="/index"/>#addcomplaint">Add New</a></h2>
	<ul class="subsubsub">
		<li class="all">All <span class="count">(0)</span> |</li>
		<li class="deleted">Deleted <span class="count">(0)</span></li>
	</ul>
	<form id="complaint-filter-form" method="post" action="/complaint/search">
		<select id="field-name" name="f">
			<option value="1">Employee</option>
			<option value="2">Equipment</option>
			<option value="3">Title</option>
		</select>
		<input type="text" id="query" name="q" />
		<div>
			<p>
				Form: <input type="text" id="dateFrom" name="dateFrom" />
				To: <input type="text" id="dateTo" name="dateTo" />
			</p>
		</div>
		<div>
			<select id="status" name="status">
				<option value="0" selected="selected">-All-</option>
				<c:forEach items="${listStatus}" var="status">
					<option value="${status.id}">${status.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select id="priority" name="priority">
				<option value="0" selected="selected">-All-</option>
				<c:forEach items="${listPriority}" var="priority">
					<option value="${priority.id}">${priority.name}</option>
				</c:forEach>
			</select>
		</div>
		<div id="filter-query-submit" class="g-b g-b-r">Filter</div>
		<div id="lnkShowAll" class="g-b g-b-b">Show All</div>
		
		<div id="complaint-viewmanager">
			<div class="gg-listview">
				<div class="gg-listview-inner">
					<div class="gg-listview-headers-container">
						<table class="gg-list-table gg-list-header-table widefat fixed complaint">
							<colgroup>
								<col class="list-col-complaintid" width="50" />
								<col class="list-col-title" />
								<col class="list-col-username" width="120" />
								<col class="list-col-equipmentname" width="100" />
								<col class="list-col-priority" width="65" />
								<col class="list-col-createdate" width="100" />
								<col class="list-col-enddate" width="100" />
								<col class="list-col-status" width="80" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">ID</span></td>
									<td><span class="gg-inner-block">Title</span></td>
									<td><span class="gg-inner-block">Employee</span></td>
									<td><span class="gg-inner-block">Equipment</span></td>
									<td><span class="gg-inner-block">Priority</span></td>
									<td><span class="gg-inner-block">Create Date</span></td>
									<td><span class="gg-inner-block">End Date</span></td>
									<td><span class="gg-inner-block">Status</span></td>
								</tr>
							</thead>
							<tbody><tr><td colspan="8"></td></tr></tbody>
						</table>
					</div>
					<div class="gg-listview-list">
						<div class="gg-list-container">
							<table class="gg-list-table widefat fixed complaint">
								<colgroup>
									<col class="list-col-complaintid" width="50" />
									<col class="list-col-title" />
									<col class="list-col-username" width="120" />
									<col class="list-col-equipmentname" width="100" />
									<col class="list-col-priority" width="65" />
									<col class="list-col-createdate" width="100" />
									<col class="list-col-enddate" width="100" />
									<col class="list-col-status" width="80" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="height:0"></tr>
								</thead>
								<tbody id="the-list" class="gg-list-tbody">
									<%@ include file="complaint_list_result.jsp" %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

</compress:html>