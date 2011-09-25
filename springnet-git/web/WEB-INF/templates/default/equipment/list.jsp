<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">
	
	<style>
		.grid {margin-top: 20px; border: 1px solid #000; border-collapse: collapse;}
		.grid td, .grid th {padding: 10px 20px ;border: 1px solid #000;}
		.grid tr.row { cursor: pointer; }
		.grid tr.row:hover { background-color: lightgray; }
		.page { display: inline-block; margin-right:3px; }
	</style>
	
	<table class = "grid">
		<tr>
			<th colspan="3">All Equipment</th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
		</tr>
		<c:if test="${msg != null}">
		<tr>
			<td colspan="3">${msg}</td>
		</tr>
		</c:if>
		<c:if test="${msg == null}">
		<c:forEach items="${listEquipment}" var="l">
			<tr class="row" onclick="return window.location.href='${contextPath}/equipment/edit${ext}?id=${l.id}'">
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td>${l.category.name}</td>
			</tr>
		</c:forEach>
		</c:if>
		<tr>
			<td colspan = "3">
				<c:forEach begin="1" end="${pageCount}" var="page">
					<a class="page" href="${contextPath}/equipment/list${ext}?page=${page}">${page}</a>
				</c:forEach>
			</td>
		</tr>
	</table>
</compress:html>
<%@ include file="../layout/footer.inc" %>