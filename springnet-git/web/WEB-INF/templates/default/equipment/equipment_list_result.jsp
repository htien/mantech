<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<c:forEach items="${listEquipment}" var="l">
	<tr class="gg-list-tr">
		<td><div class="gg-td-wrapper">${l.id}</div></td>
		<td>
			<div class="gg-td-wrapper">
				<strong>${l.name}</strong>
				<div class="gg-row-actions">
					<span><a href="<jtien:url address="/index"/>#editequipment-${l.id}">Edit</a></span>
				</div>
			</div>
		</td>
		<td><div class="gg-td-wrapper">${l.category.name}</div></td>
	</tr>
</c:forEach>
<tr>
	<td colspan = "3">
		<c:forEach begin="1" end="${pageCount}" var="page"> 
			<a class="page" href="<jtien:url address="/index"/>#listequipment-${page}">${page}</a>
		</c:forEach>
	</td>
</tr>
</compress:html>