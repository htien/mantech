<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style type="text/css">
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<div id="assignment_list_pagelet" class="g-pl">
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
								<col class="list-col-isdeleted" width="40"/>
								<col class="list-col-detail" width="50" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="gg-list-header">
									<td><span class="gg-inner-block">CompID</span></td>
									<td><span class="gg-inner-block">Begin Date</span></td>
									<td><span class="gg-inner-block">Duration</span></td>
									<td><span class="gg-inner-block">Create Date</span></td>
									<td><span class="gg-inner-block">Deleted</span></td>
									<td><span class="gg-inner-block">Detail</span></td>
								</tr>
							</thead>
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
									<col class="list-col-isdeleted" width="40"/>
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