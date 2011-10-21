<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listEquipment}" var="equipment">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${equipment.id}</div></td>
		<td>
			<div class="gg-td-wrapper">
				<strong>${equipment.name}</strong>
				<div class="gg-row-actions">
					<c:if test="${isAdmin}"><span><a href="<jtien:url address="/index"/>#editequipment/id=${equipment.id}">Edit</a></span></c:if>
				</div>
			</div>
		</td>
		<td><div class="gg-td-wrapper">${equipment.category.name}</div></td>
	</tr>
</c:forEach>
<tr>
	<td colspan = "3">
		<c:forEach begin="1" end="${pageCount}" var="page"> 
			<a class="na" href="<jtien:url address="/index"/>#listequipment/page=${page}">${page} </a>
		</c:forEach>
	</td>
</tr>
</compress:html>