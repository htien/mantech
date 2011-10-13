<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_edit_category" class="g-pl">
	<div id="editcategory_box" class="box wrap">
		<h2>Edit Category</h2>
		<f:form action="/category/editSave" commandName="category">
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
	</div>
</div>

</compress:html>