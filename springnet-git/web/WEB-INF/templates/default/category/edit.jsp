<%@ include file="../layout/header.inc" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<f:form action="editSave.htm.htm" commandName="category">
	<h2>Update new category</h2>
	<p>${msg}</p>
	<div>
		<p><f:input title="Name" path="name" /></p>
		<p><input type="submit" value="Update" /></p>
	</div>
</f:form>

<%@ include file="../layout/footer.inc" %>