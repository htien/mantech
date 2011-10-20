<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_editequipment" class="g-pl">
	<div id="editequipment-box" class="wrap">
		<h2>Edit Existing Equipment</h2>
		<form method="post" action="/equipment/editSave" >
			<input type="hidden" name="id" value="${equipment.id}" />
			<div id="equipment-edit" class="box">
				<p><br /></p>
				<table class="grid">
					<tr>
						<td class="label">Equipement ID:</td>
						<td class="t"><span>${equipment.id}</span></td>
					</tr>
					<tr>
						<td class="label">Equipment name:</td>
						<td><input type="text" value="${equipment.name}" name="name" /></td>
					</tr>
					<tr>
						<td class="label">Category:</td>
						<td>
							<select name="catId">
								<c:forEach items="${listCategory}" var="cate">
									<option value="${cate.id}" <c:if test="${equipment.category.id==cate.id}">selected="selected"</c:if>>${cate.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<div class="buttons">
					<div id="btnEdit" class="g-b g-b-r">Save</div>
				</div>
			</div>
		</form>
	</div>
</div>

</compress:html>