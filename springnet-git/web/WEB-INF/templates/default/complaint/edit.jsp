<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

	<h1>Update</h1>
	<form method="post" action="complaint/editSave${ext}">
		<input type="text" name="id" value="${complaint.id}" readonly="readonly"/>
		<select name="status">
			<c:forEach items="${listStatus}" var="ls">
				<option value="${ls.id}" <c:if test="${complaint.status.id==ls.id }">selected="selected"</c:if>>${ls.name}</option>
			</c:forEach>
		</select>
		<select name="priority">
			<c:forEach items="${listPriority}" var="lp">
				<option value="${lp.id}" <c:if test="${complaint.priority.id==lp.id }">selected="selected"</c:if>>${lp.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="update Status"/>
	</form>
	
</compress:html>
<%@ include file="../layout/footer.inc"%>