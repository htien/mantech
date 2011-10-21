<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_addcategory" class="g-pl">
	<div id="addcategory-box" class="wrap">
		<h2>Add New Category</h2>
		<form id="addcategory-form" class="g-f" method="post" action="/category/addSave">
			<div id="category-new" class="box">
				<p>Insert a new category into database.</p>
				<table class="grid">
					<tbody>
						<tr>
							<td class="label">Category name:</td>
							<td><input type="text" name="name" /></td>
						</tr>
						<tr>
							<td class="label">Choose priotity:</td>
							<td>
								<select name="priorityId">
									<c:forEach items="${priorities}" var="priority">
										<option value="${priority.id}">${priority.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="buttons">
					<div id="btnAdd" class="g-b g-b-r">Add new category</div>
					<div id="btnReset" class="g-b g-b-b">Reset</div>
				</div>
			</div>
		</form>	
	</div>
</div>

</compress:html>