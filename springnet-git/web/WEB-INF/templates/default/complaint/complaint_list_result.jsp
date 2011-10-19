<%@ include file="../layout/top.inc"%><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:forEach items="${listComplaint}" var="complaint">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${complaint.id}</div>
		</td>
		<td>
			<div class="gg-td-wrapper">
				<strong>${complaint.title}</strong>
				<div class="gg-row-actions">
					<span><a
						href="<jtien:url address="/index"/>#editcomplaint/id=${complaint.id}">Edit</a>
					</span> <span> | </span> <span><a
						href="<jtien:url address="/index"/>#addassignment/compId=${complaint.id}">New
							Assignment</a>
					</span>
				</div>
			</div></td>
		<td><div class="gg-td-wrapper">${complaint.user.username}</div>
		</td>
		<td><div class="gg-td-wrapper">${complaint.equipment.name}</div>
		</td>
		<td><div class="gg-td-wrapper">${complaint.priority.name}</div>
		</td>
		<td><div class="gg-td-wrapper">
				<fmt:formatDate value="${complaint.endDate}" pattern="${dateFormat}" />
			</div>
		</td>
		<td><div class="gg-td-wrapper">
				<fmt:formatDate value="${complaint.createDate}"
					pattern="${dateFormat}" />
				<br />
				<strong style="color: red">${complaint.status.name}</strong>
			</div>
		</td>
	</tr>
</c:forEach>

</compress:html>