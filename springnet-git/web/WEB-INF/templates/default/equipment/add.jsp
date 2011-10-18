<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_addequipment" class="g-pl">
	<div id="addequipment-box" class="wrap">
		<h2>Add New Equipment</h2>
		<form id="addequipment-form" class="g-f" method="post" action="/equipment/addSave">
			<div id="equipment-new" class="box">
				<p>Insert a new equipment into database.</p>
				<table class="grid">
					<tbody>
						<tr>
							<td class="label">Equipment name:</td>
							<td><input type="text" name="name" /></td>
						</tr>
						<tr>
							<td class="label">Choose a category:</td>
							<td>
								<select name="catId">
									<c:forEach items="${category}" var="cate">
										<option value="${cate.id}">${cate.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="buttons">
					<div id="btnAdd" class="g-b g-b-r">Insert equipment</div>
					<div id="btnReset" class="g-b g-b-b">Reset</div>
				</div>
			</div>
		</form>	
	</div>
</div>

</compress:html>