<%@ include file="../layout/top.inc"%><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<div id="pagelet_editcomplaint" class="g-pl">
	<div id="editcomplaint-box" class="box wrap">
		<h2>Edit Existing Complaint</h2>
		<form id="editcomplaint-form" class="g-f" method="post"
			action="/complaint/editSave">
			<div id="complaint-edit" class="box">
				<p>
					<br />
				</p>
				<input type="hidden" name="id" value="${complaint.id}" />
				<table class="grid">
					<tr>
						<td class="label">Complaint ID:</td>
						<td class="t"><span>${complaint.id}</span>
						</td>
					</tr>
					<tr>
						<td class="label">Employee:</td>
						<td class="t"><span>${complaint.user.firstName}
								${complaint.user.lastName}</span><span>
								(${complaint.user.username})</span>
						</td>
					</tr>
					<tr>
						<td class="label">Report on the equipment:</td>
						<td class="t"><span>${complaint.equipment.name}</span>
						</td>
					</tr>
					<tr>
						<td class="label">Title:</td>
						<td class="t"><span>${complaint.title}</span>
						</td>
					</tr>
					<tr>
						<td class="label">Content:</td>
						<td>${complaint.content}</td>
					</tr>
					<tr>
						<td class="label">Status:</td>
						<td><select name="status">
								<c:forEach items="${listStatus}" var="status">
									<option value="${status.id}"
										<c:if test="${complaint.status.id==status.id }">selected="selected"</c:if>>${status.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="label">Priority:</td>
						<td><select name="priority">
								<c:forEach items="${listPriority}" var="priority">
									<option value="${priority.id}"
										<c:if test="${complaint.priority.id==priority.id }">selected="selected"</c:if>>${priority.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="label">Create date:</td>
						<td class="t"><span>${complaint.createDate}</span>
						</td>
					</tr>
				</table>
				<div class="buttons">
					<div id="btnEdit" class="g-b g-b-r">Save information</div>
				</div>
			</div>
		</form>
	</div>
</div>

</compress:html>