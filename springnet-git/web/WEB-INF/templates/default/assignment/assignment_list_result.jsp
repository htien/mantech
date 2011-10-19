<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listAllAssignment}" var="assignment">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${assignment.complaintId}</div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${assignment.beginDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper">${assignment.duration}</div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${assignment.createDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper"></div></td>
		<td><div class="gg-td-wrapper"><a class="a" href='<jtien:url address="/index"/>#detailassignment/assignmentId=${assignment.complaintId}'>Detail</a></div></td>
	</tr>
</c:forEach>

</compress:html>