<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<f:form action="/category/editSave" commandName="category">
	<h2>Update new category</h2>
	<c:if test="${msg != null}">${msg}</c:if>
	<c:choose>
		<c:when test="${msg == null || ok == true}">
			<div>
				<p><f:input title="Name" path="name" /></p>
				<p><input type="submit" value="Update" /></p>
			</div>
		</c:when>
	</c:choose>
</f:form>

</compress:html>