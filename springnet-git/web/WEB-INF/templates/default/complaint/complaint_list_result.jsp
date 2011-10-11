<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listComplaint}" var="complaint">
	<tr>
		<td>${complaint.id}</td>
		<td>${complaint.user.username}</td>
		<td>${complaint.equipment.name}</td>
		<td>${complaint.title}</td>
		<td>${complaint.content}</td>
		<td>${complaint.priority.name}</td>
		<td>${complaint.status.name}</td>
		<td><fmt:formatDate value="${complaint.createDate}" pattern="${dateFormat}"/></td>
		<td><fmt:formatDate value="${complaint.endDate}" pattern="${dateFormat}"/></td>
		<td><a class="a" href="<jtien:url address="/index"/>#editcomplaint-${complaint.id}">Edit</a></td>
	</tr>
</c:forEach>

</compress:html>