<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
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
	<c:forEach items="${list}" var="l">
		<tr>
			<td>${l.id}</td>
			<td>${l.name}</td>
			<td><a href="category/edit${ext}?catId=${l.id}">update</a>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="../layout/footer.inc"%>