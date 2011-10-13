<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="editcomplaint_pagelet" class="g-pl">
	<div id="editcomplaint-box" class="box wrap">
		<h2>Edit Complaint</h2>
		<form id="edituser-form" class="g-f" method="post" action="/complaint/editSave">
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
		<div class="info">
			<div>
				<strong>Complaint ID:</strong> ${complaint.id}
			</div>
			<div>
				<strong>Employee:</strong> ${complaint.user.username}
			</div>
			<div>
				<strong>Equipment:</strong> ${complaint.equipment.name}
			</div>
			<div>
				<strong>Title:</strong> ${complaint.title}
			</div>
			<div>
				<strong>Content:</strong> ${complaint.content}
			</div>
			<div>
				<strong>Status:</strong> ${complaint.status.name}
			</div>
			<div>
				<strong>Priority:</strong> ${complaint.priority.name}
			</div>
			<div>
				<strong>Create Date:</strong> ${complaint.createDate}
			</div>
		</div>
	</div>
</div>

</compress:html>