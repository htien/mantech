<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

<p>
<h3>List of Assigment</h3>
<c:forEach items="${list}" var="l">
			${l.complaint.title}: ${l.createDate} - ${l.deleted ? "Deleted" : "đang duyệt"} - ${l.complaint.status.name }<br />
	<c:forEach items="${l.users}" var="u">
					${u.id}: - ${u.firstName} - ${u.role.name} <br />
	</c:forEach>
</c:forEach>
</p>
<p>
<h3>List of Exist Assigment</h3>
<c:forEach items="${listExist}" var="l">
			${l.complaint.title}: ${l.createDate} - ${l.deleted ? "Deleted" : "đang duyệt"} - <br />
	<c:forEach items="${l.users}" var="u">
					${u.id}: - ${u.firstName} - ${u.role.name} <br />
	</c:forEach>
</c:forEach>
</p>
<p>
<h3>List of Assigment by user id</h3>
<c:forEach items="${listByUserId}" var="l">
			${l.complaint.title}: ${l.createDate} - ${l.deleted ? "Deleted" : "đang duyệt"} - <br />
	<c:forEach items="${l.users}" var="u">
					${u.id}: - ${u.firstName} - ${u.role.name} <br />
	</c:forEach>
</c:forEach>
</p>
<p>
<h3>List of Assigment Completed</h3>
<c:forEach items="${listByCompleted}" var="l">
		${l.complaint.title}: ${l.createDate} - ${l.deleted ? "Deleted" : "đang duyệt"} - ${l.complaint.status.name }<br />
	<c:forEach items="${l.users}" var="u">
				${u.id}: - ${u.firstName} - ${u.role.name} <br />
	</c:forEach>
</c:forEach>
</p>

</compress:html>