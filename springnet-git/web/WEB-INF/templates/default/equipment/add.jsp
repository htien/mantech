<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">
	
	<h1>Insert</h1>
	<p>${msg}</p>
	<form method="post" action="/equipment/addSave">
		<input name="name"/>
		<select name="catId">
			<c:forEach items="${category}" var="cate">
				<option value="${cate.id}">${cate.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add"/>
	</form>
</compress:html>
<%@ include file="../layout/footer.inc" %>