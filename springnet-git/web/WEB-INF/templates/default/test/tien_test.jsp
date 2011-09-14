<%@ include file="../layout/header.inc" %>
<%@ include file="../layout/top.inc" %>
<compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<h1>Tien is testing!</h1>
	<style>
		.grid { border-collapse: collapse; }
		.grid td { padding: 1px 3px; border: 1px solid #000; }
		#info { display: none; }
	</style>
	<a id="showComplaintEdit" href="javascript:">Click here!</a>
	
	<div>
		<c:forEach items="${listUser}" var="userStats">
			${userStats.username}
		</c:forEach>
	</div>
</compress:html>
<%@ include file="../layout/footer.inc" %>