<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_listcomplaint" class="g-pl wrap">
	<h2>Complaints<a class="add-new-h2" href="<jtien:url address="/index"/>#addcomplaint">Add New</a></h2>
	<ul class="subsubsub">
		<li class="all"><a href="#">All <span class="count">(${all})</span></a> | </li>
		<li class="waiting"><a href="#">Waiting <span class="count">(${countWaiting})</span></a> | </li>
		<li class="accepted"><a href="#">Accepted <span class="count">(${countAccepted})</span></a> | </li>
		<li class="rejected"><a href="#">Rejected <span class="count">(${countRejected})</span></a> | </li>
		<li class="completed"><a href="#">Completed <span class="count">(${countCompleted})</span></a></li>
	</ul>
	<div class="clear"></div>
	<form id="complaint-filter-form" method="post" action="/complaint/search">
		<div class="search-box">
			<select id="field-name" name="f" style="margin-right:0;border-right-color:#fff">
				<option value="1">Employee</option>
				<option value="2">Equipment</option>
				<option value="3">Title</option>
			</select>
			<input type="text" id="query" name="q" size="12" style="margin-left:-1px;border-left-color:transparent" />
			<label for="dateFrom" class="label">Date</label><input type="text" id="dateFrom" name="dateFrom" size="8" readonly="readonly" />
			<label for="dateTo">-</label><input type="text" id="dateTo" name="dateTo" size="8" readonly="readonly" />
			<select id="status" name="status">
				<option value="0" selected="selected">ALL</option>
				<c:forEach items="${listStatus}" var="status">
					<option value="${status.id}">${status.name}</option>
				</c:forEach>
			</select>
			<select id="priority" name="priority">
				<option value="0" selected="selected">ALL</option>
				<c:forEach items="${listPriority}" var="priority">
					<option value="${priority.id}">${priority.name}</option>
				</c:forEach>
			</select>
			<div id="filter-query-submit" class="g-b g-b-r">Filter</div>
			<div id="lnkShowAll" class="g-b g-b-b">Show All</div>
			<script type="text/javascript">
				var dates = $('#dateFrom, #dateTo').datepicker({
					defaultDate: '+1w',
					dateFormat: 'yy/mm/dd',
					numberOfMonths: 2,
					showAnim: 'slideDown',
					changeMonth: true,
					onSelect: function(selectedDate) {
						var option = this.id == 'dateFrom' ? 'minDate' : 'maxDate',
							instance = $(this).data('datepicker'),
							date = $.datepicker.parseDate(
									instance.settings.dateFormat ||
									$.datepicker._defaults.dateFormat,
									selectedDate, instance.settings);
						dates.not(this).datepicker('option', option, date);
					}
				});
			</script>
		</div>
		<div class="tablenav">
		</div>
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