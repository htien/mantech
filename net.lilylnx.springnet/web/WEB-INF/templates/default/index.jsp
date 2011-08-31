<%@ include file="layout/header.inc" %>
<compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<h1>${welcomeMsg}</h1>
	<h2>Student:</h2>
	<p>
		ID: ${student.id}<br />
		Name: ${student.name}<br />
		Address: ${student.address.city}
	</p>
</compress:html>
<%@ include file="layout/footer.inc" %>