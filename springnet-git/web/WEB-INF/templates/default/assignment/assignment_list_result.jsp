<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listAllAssignment}" var="a">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${a.complaintId}</div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${a.beginDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper">${a.duration}</div></td>
		<td><div class="gg-td-wrapper"><fmt:formatDate value="${a.createDate}" pattern="${dateFormat}"/></div></td>
		<td><div class="gg-td-wrapper"></div></td>
		<td><div class="gg-td-wrapper"><a class="a" href='<jtien:url address="/index"/>#detailassignment-${a.complaintId}'>Detail</a></div></td>
	</tr>
</c:forEach>

</compress:html>