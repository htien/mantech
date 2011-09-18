<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">

	<h1>Insert New Complaint</h1>
	<p style="color:darkred">${errorMsg}</p>
	<form method="post" action="/complaint/addSave">
		User Name: <input type="text" value="${userId}" name="userId"/><br/>
		Equipment:	
			<select name="equipId">
				<c:forEach items="${list}" var="equip">
					<option value="${equip.id}">${equip.name}</option>
				</c:forEach>
			</select><br/>
		Title: <input type="text" name="title" value="${complaint.title}"/><br/>
		Content: <textarea rows="8" cols="30" name="content">${complaint.content}</textarea><br/>
		<input type="submit" value="Add"/>
	</form>

</compress:html>
<%@ include file="../layout/footer.inc"%>