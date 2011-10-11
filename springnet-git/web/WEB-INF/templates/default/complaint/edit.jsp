<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="editcomplaint_pagelet" class="g-pl">
	<div id="editcomplaint-box" class="box">
		<h2 class="title">Edit Complaint</h2>
		<form id="edituser-form" class="g-f" method="post" action="/complaint/editSave">
			<input type="text" name="id" value="${complaint.id}" readonly="readonly"/>
			<select name="status">
				<c:forEach items="${listStatus}" var="status">
					<option value="${status.id}" <c:if test="${complaint.status.id==status.id }">selected="selected"</c:if>>${status.name}</option>
				</c:forEach>
			</select>
			<select name="priority">
				<c:forEach items="${listPriority}" var="priority">
					<option value="${priority.id}" <c:if test="${complaint.priority.id==priority.id }">selected="selected"</c:if>>${priority.name}</option>
				</c:forEach>
			</select>
			<div id="btnEdit" class="g-b g-b-r">Save</div>
		</form>
	</div>
</div>

</compress:html>