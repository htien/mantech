<%@ include file="../layout/top.inc" %><%@ include
	file="../layout/header.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">
	
	<c:if test='${p==null}'><%@ include file="../includes/complaint/list.inc" %></c:if>
	<c:if test='${p=="add"}'><%@ include file="../includes/complaint/add.inc" %></c:if>
	<c:if test='${p=="edit"}'><%@include file="../includes/complaint/edit.inc" %></c:if>

</compress:html>
<%@ include file="../layout/footer.inc" %>