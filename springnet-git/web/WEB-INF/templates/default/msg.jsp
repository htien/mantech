<%@ include file="layout/top.inc" %>
<p>${msg}</p>
<c:if test="${userProfile != null}">
	<p>${userProfile.firstName} ${userProfile.lastName} &lt;${userProfile.email}&gt;</p>
</c:if>