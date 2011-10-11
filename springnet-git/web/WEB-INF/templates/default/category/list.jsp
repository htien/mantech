<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<style>
	.grid { margin-top:20px; border:1px solid #000; border-collapse:collapse; }
	.grid td, .grid th { padding:2px 4px; border:1px solid #000; }
</style>

<strong>List of Category:</strong>

<table class="grid">
	<tr>
		<th>id</th>
		<th>Category</th>
		<th>Update</th>
	</tr>
	<c:forEach items="${listCategory}" var="category">
		<tr>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td><a href="<jtien:url address="/index"/>#editcategory-${category.id}">update</a></td>
		</tr>
	</c:forEach>
</table>

</compress:html>