<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listComplaint}" var="complaint">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${complaint.id}</div></td>
		<td><div class="gg-td-wrapper">${complaint.user.username}</div></td>
		<td><div class="gg-td-wrapper">${complaint.equipment.name}</div></td>
		<td><div class="gg-td-wrapper">${complaint.title}</div></td>
		<td><div class="gg-td-wrapper">${complaint.priority.name}</div></td>
		<td><div class="gg-td-wrapper">${complaint.status.name}</div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${complaint.createDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${complaint.endDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper"><a class="a" href="<jtien:url address="/index"/>#editcomplaint-${complaint.id}">Edit</a></div></td>
	</tr>
</c:forEach>

</compress:html>