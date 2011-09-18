<%@ include file="layout/header.inc" %>
<%@ include file="layout/top.inc" %>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<h1>${welcomeMsg}</h1>
	<form method="post" action="/abc">
		<input id="btn" type="button" value="Button" />
	</form>
</compress:html>
<%@ include file="layout/footer.inc" %>