<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="pagelet_addequipment" class="g-pl">
	<div id="addequipment-box" class="box wrap">
		<h2>Add New Equipment</h2>
		<form id="addequipment-form" class="g-f" method="post" action="/equipment/addSave">
			<div class="row">
				<label>
					<strong>Name: </strong>
					<input type="text" name="name"/>				
				</label>
			</div>
			<div class="row">
				<label>
					<strong>Category: </strong>
					<select name="catId">
						<c:forEach items="${category}" var="cate">
							<option value="${cate.id}">${cate.name}</option>
						</c:forEach>
					</select>			
				</label>
			</div>
			<div id="btnAdd" class="g-b g-b-r">Add new equipment</div>
			<div id="btnReset" class="g-b g-b-b">Reset</div>
		</form>	
	</div>
</div>

</compress:html>