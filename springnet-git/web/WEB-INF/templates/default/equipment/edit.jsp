<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_edit_equipment" class="g-pl">
	<div id="editequipment_box" class="box wrap">
		<h2>Edit Equipment</h2>
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
		<a href="${contextPath}/equipment/list${ext}">Back to List Equipment</a>
	</div>
</div>

</compress:html>