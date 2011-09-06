<%@ include file="../layout/header.inc" %>
<compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<p>
		ID: ${lastCate.id}<br />
		Name: ${lastCate.name}<br />
		Priority: ${lastCate.categoryPriority.name}
	</p>
</compress:html>
<%@ include file="../layout/footer.inc" %>