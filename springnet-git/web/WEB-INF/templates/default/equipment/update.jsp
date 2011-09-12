<%@ include file="../layout/header.inc"%>
<%@ include file="../layout/top.inc"%>
<compress:html jsCompressor="closure" compressJavaScript="true"
	compressCss="true" removeIntertagSpaces="true">
	
	<h3>Update</h3>
	<f:form method="post" action = "/springnet/equipment/updateSave.htm" commandName="equipment" >
		<p><f:input path="name" title="Name"/></p>
		<div>
			<f:select path="category" items="${listCategory}" itemLabel="name" itemValue="id"/>
		</div>
		<p><input type="submit" value="Update"/></p>
	</f:form>
</compress:html>
<%@ include file="../layout/footer.inc" %>