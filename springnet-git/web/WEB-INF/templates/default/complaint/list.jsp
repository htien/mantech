<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style>
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<div id="complaint_list_pagelet" class="g-pl">
	<div id="container" style="width: 700px; height: 400px;"></div>
	
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
		<table class="gg-list-table complaints grid">
			<thead><tr><th>Id</th><th>Employee</th><th>Equipment name</th><th>Title</th><th>Content</th><th>Priority</th><th>Status</th><th>Created date</th><th>End date</th><th>Edit</th></tr></thead>
			<tfoot><tr><th>Id</th><th>Employee</th><th>Equipment name</th><th>Title</th><th>Content</th><th>Priority</th><th>Status</th><th>Created date</th><th>End date</th><th>Edit</th></tr></tfoot>
			<tbody id="the-list">
				<%@ include file="complaint_list_result.jsp" %>
			</tbody>
		</table>
	</form>
	<script>startChart();</script>
</div>

</compress:html>