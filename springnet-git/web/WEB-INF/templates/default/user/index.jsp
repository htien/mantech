<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:if test='${p=="list"}'><%@ include file="list.inc" %></c:if>
<c:if test='${p=="add"}'><%@ include file="add.inc" %></c:if>
<c:if test='${p=="edit"}'><%@ include file="edit.inc" %></c:if>

</compress:html>