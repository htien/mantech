<%@ include file="../../layout/top.inc"%>
<div id="editcomplaint_pagelet" class="g-pl">
	<div id="editcomplaint-box" class="box">
		<h2 class="title">Edit Complaint</h2>
		<form id="edituser-form" class="g-f" method="post" action="/complaint/editSave">
			<input type="text" name="id" value="${complaint.id}" readonly="readonly"/>
			<select name="status">
				<c:forEach items="${listStatus}" var="ls">
					<option value="${ls.id}" <c:if test="${complaint.status.id==ls.id }">selected="selected"</c:if>>${ls.name}</option>
				</c:forEach>
			</select>
			<select name="priority">
				<c:forEach items="${listPriority}" var="lp">
					<option value="${lp.id}" <c:if test="${complaint.priority.id==lp.id }">selected="selected"</c:if>>${lp.name}</option>
				</c:forEach>
			</select>
			<div id="btnEdit" class="g-b g-b-r">Save</div>
		</form>
	</div>
</div>
	