<%@ include file="../layout/top.inc"%>
<%@ include file="../layout/header.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">


<style>
	.grid {margin-top: 15px; border: 1px solid #000; border-collapse: collapse;}
	.grid th, .grid td {border: 1px solid #000; border-collapse: collapse}
</style>

<script type="text/javascript">
	$(function() {
		$("#btnSearch").click(function() {
			var responseText = jTien.f.ajaxConnect("#container", 
					$ctx + "/complaint/search.php", {q: $("#txtSearch").val(),
					yourchoice: $("#yourChoice").val()}, "POST");
			if (responseText.length == 0) {
				$("#container").html('Nothing to show');
			}
		});
		$("#lnkShowAll").click(function() {
			jTien.f.ajaxConnect("#container", 
					$ctx + "/complaint/search.php", {q: '', yourchoice: '0'}, "POST");
		});
	});
</script>

	<input id="txtSearch" type="text" name="search" value=""/>
	<button id="btnSearch">Search</button><a id="lnkShowAll" href="javascript:">Show all</a>
	<select id="yourChoice" name="yourChoice">
		<option value = "1">Employee</option>
		<option value = "2">Equipment</option>
	</select>
	<div id="container">
		<table class="grid">
			<tr>
				<th>Id</th>
				<th>Employee</th>
				<th>Equipment name</th>
				<th>Title</th>
				<th>Content</th>
				<th>Priority</th>
				<th>Status</th>
				<th>Created date</th>
				<th>End date</th>
			</tr>
			<tr>
				<c:forEach items="${listAll}" var="complaint">
					<tr>
						<td>${complaint.id}</td>
						<td>${complaint.user.username}</td>
						<td>${complaint.equipment.name}</td>
						<td>${complaint.title}</td>
						<td>${complaint.content}</td>
						<td>${complaint.priority.name}</td>
						<td>${complaint.status.name}</td>
						<td>${complaint.createDate}</td>
						<td>${complaint.endDate}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>


<!-- <div> -->
<!-- 	Page 1:<br/> -->
<%-- 	<c:forEach items="${list}" var="comp"> --%>
<%-- 		${comp.id}: ${comp.user.firstName} ${comp.equipment.name} ${comp.title}  --%>
<%-- 		--- <c:forEach items="${comp.details}" var="detail"> --%>
<%-- 				${detail.user.firstName} , --%>
<%-- 			</c:forEach> --%>
<!-- 		<br /> -->
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	<h3>List complaint without assignment</h3> -->
<%-- 	<c:forEach items="${listComplaintWaiting}" var="comp"> --%>
<%-- 		${comp.id}: ${comp.user.firstName} - ${comp.user.role.name} --%>
<%-- 		- ${comp.user.department.name} --%>
<%-- 		- ${comp.equipment.name} - ${comp.status.name} - ${comp.title} --%>
<%-- 		-${comp.content} - ${comp.priority.name} - ${comp.createDate}  --%>
<%-- 		<a href="/springnet/assignment/add${ext}?compId=${comp.id}">Assign</a><br /> --%>
<%-- 	</c:forEach>	 --%>
<!-- </div> -->

<%-- <h1>No of Complaint: ${no}</h1> --%>
<!-- <div> -->
<!-- 	<h3>Sort Complaints by id or equipment:</h3> -->
<%-- 	<c:forEach items="${listComplaint}" var="listComp"> --%>
<%-- 		${listComp.id}: ${listComp.user.firstName} - ${listComp.user.role.name} --%>
<%-- 		- ${listComp.user.department.name} --%>
<%-- 		- ${listComp.equipment.name} - ${listComp.status.name} - ${listComp.title} --%>
<%-- 		-${listComp.content} - ${listComp.priority.name} - ${listComp.createDate} <br /> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <h3>Show Complaint weekly:</h3> -->
<!-- <div> -->
<%-- 	<c:forEach items="${complaintInWeek}" var="weekly"> --%>
<%-- 		${weekly.id}: ${weekly.equipment.name} - ${weekly.title} - ${weekly.content}  --%>
<%-- 		// ${weekly.user.firstName} - ${weekly.user.department.name}  --%>
<%-- 		- ${weekly.priority.name} - ${weekly.createDate} <br/>  --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	Number of complaints in department Learning Services: -->
<%-- 	${complaintByDepartment.size()} --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	List complaints by priority:<br/> -->
<%-- 	<c:forEach items="${complaintByPriority}" var="l"> --%>
<%-- 		${l.id}: ${l.user.firstName} - ${l.user.role.name} --%>
<%-- 		- ${l.user.department.name} --%>
<%-- 		- ${l.equipment.name} - ${l.status.name} - ${l.title} --%>
<%-- 		-${l.content} - ${l.priority.name} - ${l.createDate} <br/> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	List complaints by FirstName:<br/> -->
<%-- 	<c:forEach items="${complaintByFirstName}" var="l"> --%>
<%-- 		${l.id}: ${l.user.firstName} - ${l.user.role.name} --%>
<%-- 		- ${l.user.department.name} --%>
<%-- 		- ${l.equipment.name} - ${l.status.name} - ${l.title} --%>
<%-- 		-${l.content} - ${l.priority.name} - ${l.createDate} <br /> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	<h3>List complaints by Date:</h3> -->
<%-- 	<c:forEach items="${complaintByDate}" var="l"> --%>
<%-- 		${l.id}: ${l.user.firstName} - ${l.user.role.name} --%>
<%-- 		- ${l.user.department.name} --%>
<%-- 		- ${l.equipment.name} - ${l.status.name} - ${l.title} --%>
<%-- 		-${l.content} - ${l.priority.name} - ${l.createDate} <br /> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	<h3>List Complaints from date to date:</h3> -->
<%-- 	<c:forEach items="${complaintsFromDateToDate}" var="l"> --%>
<%-- 		${l.id}: ${l.user.firstName} - ${l.user.role.name} --%>
<%-- 		- ${l.user.department.name} --%>
<%-- 		- ${l.equipment.name} - ${l.status.name} - ${l.title} --%>
<%-- 		-${l.content} - ${l.priority.name} - ${l.createDate} <br /> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

<!-- <div> -->
<!-- 	<h3>List Complaints By Year:</h3> -->
<%-- 	<c:forEach items="${complaintYear}" var="l"> --%>
<%-- 		${l.id}: ${l.user.firstName} - ${l.user.role.name} --%>
<%-- 		- ${l.user.department.name} --%>
<%-- 		- ${l.equipment.name} - ${l.status.name} - ${l.title} --%>
<%-- 		-${l.content} - ${l.priority.name} - ${l.createDate} <br /> --%>
<%-- 	</c:forEach> --%>
<!-- </div> -->

</compress:html>