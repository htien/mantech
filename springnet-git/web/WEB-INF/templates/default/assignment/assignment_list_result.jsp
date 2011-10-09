<%@ include file="../layout/top.inc"%><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:forEach items="${listAllAssignment}" var="a">
	<tr>
		<td>${a.complaintId}</td>
		<td><fmt:formatDate value="${a.beginDate}" pattern="${dateFormat}"/></td>
		<td>${a.duration}</td>
		<td><fmt:formatDate value="${a.createDate}" pattern="${dateFormat}"/></td>
		<td></td>
		<td><a href='<jtien:url address="/assignment"/>?p=detail&compId=${a.complaintId}'>Detail</a></td>
	</tr>
</c:forEach>

</compress:html>