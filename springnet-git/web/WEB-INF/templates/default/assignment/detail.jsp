<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<h2>Details</h2>
<div>

	<div id="assignment-viewmanager">
		<div class="gg-listview">
			<div class="gg-listview-inner">
				<div class="gg-listview-headers-container">
					<table class="gg-list-table gg-list-header-table widefat fixed assignment">
						<colgroup>
							<col class="list-col-complaintdetailid" width="50" />
							<col class="list-col-complaintid" width="100" />
							<col class="list-col-duration" width="80" />
							<col class="list-col-createdate" width="80" />
							<col class="list-col-isdeleted" />
						</colgroup>
						<thead class="gg-list-thead">
							<tr class="gg-list-header">
								<td><span class="gg-inner-block">Id</span></td>
								<td><span class="gg-inner-block">Complaint Id</span></td>
								<td><span class="gg-inner-block">Duration</span></td>
								<td><span class="gg-inner-block">Create Date</span></td>
								<td><span class="gg-inner-block">Username</span></td>
							</tr>
						</thead>
						<tbody><tr><td colspan="6"></td></tr></tbody>
					</table>
				</div>
				<div class="gg-listview-list">
					<div class="gg-list-container">
						<table class="gg-list-table widefat fixed assignment">
							<colgroup>
								<col class="list-col-complaintdetailid" width="50" />
								<col class="list-col-complaintid" width="100" />
								<col class="list-col-duration" width="80" />
								<col class="list-col-createdate" width="80" />
								<col class="list-col-isdeleted" />
							</colgroup>
							<thead class="gg-list-thead">
								<tr class="height:0"></tr>
							</thead>
							<tbody id="the-list" class="gg-list-tbody">
								<c:forEach items="${details}" var="d">
									<tr class="gg-list-tr">
										<td><div class="gg-td-wrapper">${d.id}</div></td>
										<td><div class="gg-td-wrapper">${d.assignment.complaintId}</div></td>
										<td><div class="gg-td-wrapper">${d.assignment.duration }</div></td>
										<td><div class="gg-td-wrapper"><fmt:formatDate value="${d.assignment.createDate}" pattern="${dateFormat}"/></div></td>
										<td><div class="gg-td-wrapper">${d.user.username}</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>	
</div>

</compress:html>