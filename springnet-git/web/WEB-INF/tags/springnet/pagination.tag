<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://code.google.com/p/springnet" prefix="jtien"%>

<%@ attribute name="info" required="true" type="net.lilylnx.springnet.util.Pagination"%>

<c:if test="${info.totalRecords > info.recordsPerPage}">
	<div class="pagination">
		<%-- Previous page --%>
		<c:if test="${info.thisPage > 1}">

				<c:set var="extraArgs" value="/page=${info.thisPage - 1}"/>

			<a href="<jtien:url address="/index"/>${info.baseUrl}${extraArgs}">&#9668;</a>
		</c:if>

		<c:remove var="extraArgs"/>
		<%-- Next page --%>
		<c:if test="${info.thisPage < info.totalPages}">
			<c:set var="extraArgs" value="/page=${info.thisPage + 1}"/>
			<c:if test="${info.id > 0}">
				<c:set var="extraArgs" value="${extraArgs};id=${info.id}"/>
			</c:if>
			<a href="<jtien:url address="/index"/>${info.baseUrl}${extraArgs}">&#9658;</a>
		</c:if>
	</div>
</c:if>