<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_listassignment" class="g-pl wrap">
	<h2>Assignments</h2>
	<form id="assignment-filter-form">
		<div id="assignment-viewmanager">
			<div class="gg-listview">
				<div class="gg-listview-inner">
					<div class="gg-listview-headers-container">
						<table class="gg-list-table gg-list-header-table widefat fixed assignment">
							<colgroup>
								<col class="list-col-complaintid" width="70" />
								<col class="list-col-begindate" width="80"/>
								<col class="list-col-duration" width="60" />
								<col class="list-col-createdate" width="80"/>
								<col class="list-col-isstatus" width="40"/>
								<col class="list-col-detail" width="50" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">CompID</span></td>
									<td><span class="gg-inner-block">Begin Date</span></td>
									<td><span class="gg-inner-block">Duration</span></td>
									<td><span class="gg-inner-block">Create Date</span></td>
									<td><span class="gg-inner-block">Status</span></td>
									<td><span class="gg-inner-block">Detail</span></td>
								</tr>
							</thead>
							<tbody><tr><td colspan="6"></td></tr></tbody>
						</table>
					</div>
					<div class="gg-listview-list">
						<div class="gg-list-container">
							<table class="gg-list-table widefat fixed assignment">
								<colgroup>
									<col class="list-col-complaintid" width="70" />
									<col class="list-col-begindate" width="80"/>
									<col class="list-col-duration" width="60" />
									<col class="list-col-createdate" width="80"/>
									<col class="list-col-isstatus" width="40"/>
									<col class="list-col-detail" width="50" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="height:0"></tr>
								</thead>
								<tbody id="the-list" class="gg-list-tbody">
									<%@ include file="assignment_list_result.jsp" %>
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