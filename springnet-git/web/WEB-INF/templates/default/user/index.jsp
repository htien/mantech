<%@ include file="../layout/top.inc" %><%@ include
	file="../layout/header.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:if test='${p==null}'><%@ include file="list.inc" %></c:if>
<c:if test='${p=="add"}'><%@ include file="add.inc" %></c:if>
<c:if test='${p=="edit"}'><%@ include file="edit.inc" %></c:if>

</compress:html><%@ include file="../layout/footer.inc" %>