<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">
	
	<h3>Update</h3>
	<p>${msg}></p>
	<form method="post" action = "/equipment/editSave" >
		<input type="hidden" name="id" value="${equipment.id}" />
		<p><input value="${equipment.name}" name="name"/></p>
		<div>
			<select name="catId">
				<c:forEach items="${listCategory}" var="cate">
					<option value="${cate.id}" <c:if test="${equipment.category.id==cate.id}">selected="selected"</c:if>>${cate.name}</option>
				</c:forEach>
			</select>
		</div>
		<p><input type="submit" value="Update"/></p>
	</form>
	<a href="list${ext}">Back to List Equipment</a>
</compress:html>
<%@ include file="../layout/footer.inc" %>