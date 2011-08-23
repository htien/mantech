<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@
taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %><%@
taglib uri="http://www.springframework.org/tags/form" prefix="form" %><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration Page</title>
<style type="text/css">
	#userInfo .grid { margin-left:auto; margin-right:auto; }
</style>
</head>
<body>
	<form:form id="userInfo" method="post" commandName="userInfo">
		<table class="grid">
			<tr><td>User Name:</td><td><form:input path="name" autocomplete="off" /></td></tr>
			<tr><td>Password:</td><td><form:password path="password" /></td></tr>
			<tr>
				<td>Gender:</td>
				<td>
					<form:radiobutton path="gender" value="M" label="M" />
					<form:radiobutton path="gender" value="F" label="F" />
				</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<form:select path="country">
						<form:option value="0" label="- Select -" />
						<form:option value="1" label="India" />
						<form:option value="2" label="USA" />
						<form:option value="3" label="UK" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Community:</td>
				<td>
					<form:checkbox path="community" value="Spring" label="Spring" />
					<form:checkbox path="community" value="Struts" label="Struts" />
				</td>
			</tr>
			<tr><td>About You:</td><td><form:textarea path="aboutYou" /></td></tr>
			<tr><td></td><td><form:checkbox path="mailingList" label="Would you like join our mailing list?" /></td></tr>
			<tr><td colspan="2"><input type="submit" /></td></tr>
		</table>
	</form:form>
	<script>
		function xinchao(name) {
			alert('Hello ' + name); 
		}
		xinchao('Tien');
	</script>
</body>
</html>
</compress:html>