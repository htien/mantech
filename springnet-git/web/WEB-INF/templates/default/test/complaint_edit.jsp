<%@ include file="../layout/top.inc" %>
<div id="complaint_edit_form">
	<table class="grid">
		<tbody>
		<c:forEach items="${listComplaint}" var="comp">
			<tr>
				<td>${comp.id}</td>
				<td>${comp.user.firstName}</td>
				<td>${comp.equipment.name}: ${comp.status.name}</td>
				<td>${comp.title}</td>
				<td>${comp.content}</td>
				<td>${comp.priority.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>