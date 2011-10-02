<%@ include file="layout/top.inc" %><%@ include file="layout/header.inc" %><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div id="blueBar">
	<div id="companyName">Mantech<sup>®</sup> <span>Help Desk</span></div>
</div>

<c:if test='${p==null || !p.equals("login")}'><%@ include file="includes/springnet_info.inc" %></c:if>
<c:if test='${p.equals("login")}'><%@ include file="includes/admin_login.inc" %></c:if>

</compress:html><%@ include file="layout/footer.inc" %>