<%@ include file="../layout/top.inc"%><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<h3>List of Assigment</h3>
<c:forEach items="${listComplaint}" var="c">
	${c.assignment.createDate} - ${c.equipment.name} - ${c.assignment.deleted ? "Deleted" : "dang duyet"}<br />
</c:forEach>

<h3>Show all complaint with assignment of without assignment</h3>
<c:forEach items="${listAllComplaint}" var="complaint">
	${complaint.id} - ${complaint.assignment.createDate} <br />
</c:forEach>

</compress:html>
<%@ include file="../layout/footer.inc"%>