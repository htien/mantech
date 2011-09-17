<%@ include file="layout/header.inc" %>
<%@ include file="layout/top.inc" %>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<h1>${welcomeMsg}</h1>
	<p>${contextPath}</p>
	<p>${ext}</p>
</compress:html>
<%@ include file="layout/footer.inc" %>