<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.inc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				${l.user.firstName } ,
			</c:forEach>
		<br />
	</c:forEach>
</p>
<p>
	No of Complaint: ${no}
</p>
<p>
	<c:forEach items="${listComplaint}" var="listComp">
		${listComp.id }: ${listComp.user.firstName } - ${listComp.user.role.name}
		- ${listComp.user.department.name}
		- ${listComp.equipment.name } - ${listComp.status.name } - ${listComp.title }
		-${listComp.content } - ${listComp.priority.name } - ${listComp.createDate } <br />
	</c:forEach>
</p>
<br/>
Show Complaint weekly:
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
</compress:html>