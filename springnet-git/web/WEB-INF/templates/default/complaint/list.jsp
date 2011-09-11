<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

<!-- 	<p> -->
<%-- 		ID: ${lastCate.id}<br /> --%>
<%-- 		Name: ${lastCate.name}<br /> --%>
<%-- 		Priority: ${lastCate.priority.name} --%>
<!-- 	</p> -->

<p>
	Page 1:<br/>
	<c:forEach items="${list}" var="list">
		${list.id}: ${list.user.firstName} ${list.equipment.name} ${list.title} 
		--- <c:forEach items="${list.assignment.details}" var="l">
				${l.user.firstName} ,
			</c:forEach>
		<br />
	</c:forEach>
</p>
<h1>No of Complaint: ${no}</h1>
<p>
	<h3>Sort Complaints by id or equipment:</h3>
	<c:forEach items="${listComplaint}" var="listComp">
		${listComp.id}: ${listComp.user.firstName} - ${listComp.user.role.name}
		- ${listComp.user.department.name}
		- ${listComp.equipment.name} - ${listComp.status.name} - ${listComp.title}
		-${listComp.content} - ${listComp.priority.name} - ${listComp.createDate} <br />
	</c:forEach>
</p>
<br/>
<h3>Show Complaint weekly:</h3>
<p>
	<c:forEach items="${complaintInWeek}" var="weekly">
		${weekly.id}: ${weekly.equipment.name} - ${weekly.title} - ${weekly.content} 
		// ${weekly.user.firstName} - ${weekly.user.department.name} 
		- ${weekly.priority.name} - ${weekly.createDate} <br/> 
	</c:forEach>
</p>
<p>
	Number of complaints in department Learning Services:
	${complaintByDepartment.size()}
</p>
<p>
	List complaints by priority:<br/>
	<c:forEach items="${complaintByPriority}" var="l">
		${l.id}: ${l.user.firstName} - ${l.user.role.name}
		- ${l.user.department.name}
		- ${l.equipment.name} - ${l.status.name} - ${l.title}
		-${l.content} - ${l.priority.name} - ${l.createDate} <br />
	</c:forEach>
</p>
<p>
	List complaints by FirstName:<br/>
	<c:forEach items="${complaintByFirstName}" var="l">
		${l.id}: ${l.user.firstName} - ${l.user.role.name}
		- ${l.user.department.name}
		- ${l.equipment.name} - ${l.status.name} - ${l.title}
		-${l.content} - ${l.priority.name} - ${l.createDate} <br />
	</c:forEach>
</p>
<p>
	<h3>List complaints by Date:</h3>
	<c:forEach items="${complaintByDate}" var="l">
		${l.id}: ${l.user.firstName} - ${l.user.role.name}
		- ${l.user.department.name}
		- ${l.equipment.name} - ${l.status.name} - ${l.title}
		-${l.content} - ${l.priority.name} - ${l.createDate} <br />
	</c:forEach>
</p>
<p>
	<h3>List Complaints from date to date:</h3>
	<c:forEach items="${complaintsFromDateToDate}" var="l">
		${l.id}: ${l.user.firstName} - ${l.user.role.name}
		- ${l.user.department.name}
		- ${l.equipment.name} - ${l.status.name} - ${l.title}
		-${l.content} - ${l.priority.name} - ${l.createDate} <br />
	</c:forEach>
</p>
<p>
	<h3>List Complaints By Year:</h3>
	<c:forEach items="${complaintYear}" var="l">
		${l.id}: ${l.user.firstName} - ${l.user.role.name}
		- ${l.user.department.name}
		- ${l.equipment.name} - ${l.status.name} - ${l.title}
		-${l.content} - ${l.priority.name} - ${l.createDate} <br />
	</c:forEach>
</p>
</compress:html>