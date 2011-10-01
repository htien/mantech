<%@ include file="../layout/header.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="addcomplaint_pagelet" class="g-pl">
	<div id="addcomplaint-box" class="box">
		<h2 class="title">Insert New Complaint</h2>
		<form id="addcomplaint-form" class="g-f" method="post" action="/complaint/addSave">
			<p id="msg"></p>
			<div>
				<div class = "row">
					<label><strong>${user.firstName} ${user.lastName}</strong></label>
				</div>
				<div class="row">
					<label>
						<strong>Equipment: </strong>	
						<select name="equipId" class="unfocus">
							<c:forEach items="${list}" var="equip">
								<option value="${equip.id}">${equip.name}</option>
							</c:forEach>
						</select>			
					</label>
				</div>
				<div class="row">
					<label>
						<strong>Title: </strong>
						<input type="text" name="title"/>
					</label>
				</div>
				<div class="row">
					<strong>Content: </strong>
					<textarea id="content" name="content" rows="5"></textarea>
				</div>
			</div>
			<div>
				<div id="btnAdd" class="g-b g-b-r">Add new complaint</div>
				<div id="btnReset" class="g-b g-b-b">Reset</div>
			</div>
		</form>
	</div>
</div>

</compress:html>
<%@ include file="../layout/footer.inc"%>