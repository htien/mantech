<%@ include file="../layout/top.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${complaints}" var="complaint">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${complaint.id}</div></td>
		<td>
			<div class="gg-td-wrapper">
				<strong>${complaint.title}</strong>
				<div class="gg-row-actions">
					<a href="<jtien:url address="/index"/>#editcomplaint/id=${complaint.id}">Edit</a>
					<c:if test="${isAdmin}">| <a href="<jtien:url address="/index"/>#addassignment/compId=${complaint.id}">New Assignment</a></c:if>
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