<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.inc"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

<p>
	<c:forEach items="${listUser}" var="list">
			${list.id }: ${list.firstName } - ${list.department.name } 
			- ${list.role.name } - ${list.complaints.size() } <br />
		<c:forEach items="${list.complaints }" var="c">
						${c.title } <br />
		</c:forEach>
		<br />
	</c:forEach>
</p>

</compress:html>
<%@ include file="../layout/footer.inc"%>