<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_editcategory" class="g-pl">
	<div id="editcategory-box" class="box wrap">
		<h2>Edit Existing Category</h2>
		<f:form action="/category/editSave" commandName="category">
			<input type="hidden" name="cateId" value="${category.id}" />
			<div id="category-edit" class="box">
				<p><br /></p>
				<table class="grid">
					<tr>
						<td class="label">Category name:</td>
						<td><input type="text" value="${category.name}" name="name" /></td>
					</tr>
				</table>
				<div class="buttons">
					<div id="btnEdit" class="g-b g-b-r">Save information</div>
				</div>
			</div>
		</f:form>
	</div>
</div>

</compress:html>