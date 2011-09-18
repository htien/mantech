<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

	<style>
		.grid {border: 1px solid #000; border-collapse: collapse;}
		.grid th, .grid td {border: 1px solid #000; border-collapse: collapse; padding: 1px 2px;}
		.grid .row:hover {background-color: #eee; cursor: pointer;}
	</style>
	
	<h1>Add new Assignment</h1>
	
	<form method="post" action="assignment/addSave${ext}">
		Begin Date: <input type="text" name="beginDate"/><br/>
		Duration: <input type="text" name="duration"/><br/>
		User Id:
		<select name="userId" multiple="multiple">
			<option value="3">A</option>
			<option value="5">B</option>
		</select>
		<input type="submit" value="Add"/>
<!-- 		<hr/> -->
<!-- 		Complaint Details:<br/> -->
<!-- 		Id: <input type="text" name="complaintId" readonly="readonly"/><br/> -->
<!-- 		EmployeeId: <input type="text" name="employeeId" readonly="readonly"/><br/> -->
<!-- 		Employee: <input type="text" name="employeeName" readonly="readonly"/><br/> -->
<!-- 		Status: <input type="text" name="status" readonly="readonly"/><br/> -->
<!-- 		Title: <input type="text" name="title" readonly="readonly"/><br/> -->
<!-- 		Content: <input type="text" name="content" readonly="readonly"/><br/> -->
<!-- 		Priority: <input type="text" name="priority" readonly="readonly"/><br/> -->
<!-- 		Create date: <input type="text" name="createDate" readonly="readonly"/><br/> -->
<!-- 		<hr/> -->
		<table class="grid">
			<tr>
				<th colspan="8">List of complaint</th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Status</th>
				<th>Title</th>
				<th>Content</th>
				<th>Priority</th>
				<th>Create Date</th>
			</tr>
			<c:forEach items="${listComplaint}" var="l">
				<tr class="row">
					<td>${l.id}</td>
					<td>${l.user.id}</td>
					<td>${l.user.firstName}</td>
					<td>${l.status.name}</td>
					<td>${l.title}</td>
					<td>${l.content}</td>
					<td>${l.priority.name}</td>
					<td>${l.createDate}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
</compress:html>
<%@ include file="../layout/footer.inc"%>