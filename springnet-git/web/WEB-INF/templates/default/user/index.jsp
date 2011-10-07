<%@ include file="../layout/top.inc" %><%@ include
	file="../layout/header.inc" %><compress:html jsCompressor="closure"
	compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:if test='${p==null}'><%@ include file="../includes/user/list.inc" %></c:if>
<c:if test='${p=="add"}'><%@ include file="../includes/user/add.inc" %></c:if>
<c:if test='${p=="edit"}'><%@ include file="../includes/user/edit.inc" %></c:if>

</compress:html>
<%@ include file="../layout/footer.inc" %>