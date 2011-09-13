<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

	<h1>Insert New Complaint</h1>
	
	<form method="post" action="/springnet/complaint/insertSave.htm">
		User Name: <input type="text" value="${userId}" name="userId"/><br/>
		Equipment:	
			<select name="equipId">
				<c:forEach items="${list}" var="l">
					<option value="${l.id}">${l.name}</option>
				</c:forEach>
			</select><br/>
		Title: <input type="text" name = "title"/><br/>
		Content: <textarea rows="8" cols="30" name="content"></textarea><br/>
		<input type="submit" value="Add"/>
	</form>

</compress:html>
<%@ include file="../layout/footer.inc"%>