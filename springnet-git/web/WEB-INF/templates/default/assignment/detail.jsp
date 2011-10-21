<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_detailassignment" class="wrap">
	<h2>Assignment Details</h2>
	<p><br/></p>
	<div class="wrap">
		<p>Complaint Title: ${complaint.title}</p>
		<p><a href="<jtien:url address="/index"/>#completeassignment/compId=${complaint.id}">Click for complete</a></p>
	</div>
	<p><br /></p>
	<div id="assignment-viewmanager">
		<div id="form">
			<form id="addassignment-form" class="g-f" method="post" action="/assignment/complete" >
				<div class="gg-listview">
					<div class="gg-listview-inner">
						<div class="gg-listview-headers-container">
							<table class="gg-list-table gg-list-header-table widefat fixed assignment">
								<colgroup>
									<col class="list-col-complaintdetailid" width="50" />
									<col class="list-col-duration" width="80" />
									<col class="list-col-createdate" width="80" />
									<col class="list-col-username" width="100" />
									<col class="list-col-completedate" width="100"/>
									<col class="list-col-completedate" />
								</colgroup>
								<thead class="gg-list-thead">
									<tr class="gg-list-header">
										<td><span class="gg-inner-block">Id</span></td>
										<td><span class="gg-inner-block">Duration</span></td>
										<td><span class="gg-inner-block">Create Date</span></td>
										<td><span class="gg-inner-block">Username</span></td>
										<td><span class="gg-inner-block">Complete Date</span></td>
										<td><span class="gg-inner-block"></span></td>
										<td></td>
									</tr>
								</thead>
								<tbody><tr><td colspan="5"></td></tr></tbody>
							</table>
						</div>
						<div class="gg-listview-list">
							<div class="gg-list-container">
								<table class="gg-list-table widefat fixed assignment">
									<colgroup>
										<col class="list-col-complaintdetailid" width="50" />
										<col class="list-col-duration" width="80" />
										<col class="list-col-createdate" width="80" />
										<col class="list-col-username" width="100" />
										<col class="list-col-completedate" width="100"/>
										<col class="list-col-complete" />
									</colgroup>
									<thead class="gg-list-thead">
										<tr class="height:0"></tr>
									</thead>
									<tbody id="the-list" class="gg-list-tbody">
										<c:forEach items="${complaint.details}" var="detail">
											<tr class="gg-list-tr">
												<td><div class="gg-td-wrapper">${detail.id}</div></td>
												<td><div class="gg-td-wrapper">${complaint.assignment.duration}</div></td>
												<td><div class="gg-td-wrapper"><fmt:formatDate value="${complaint.assignment.createDate}" pattern="${dateFormat}"/></div></td>
												<td><div class="gg-td-wrapper">
													<strong>${detail.user.username}</strong>
													</div>
												</td>
												<td><div class="gg-td-wrapper"><fmt:formatDate value="${detail.completeDate}" pattern="${dateFormat}"/></div></td>
												<td></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>	
</div>

</compress:html>