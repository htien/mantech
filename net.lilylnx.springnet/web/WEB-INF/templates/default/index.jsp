<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@
taglib uri="http://www.springframework.org/tags/form" prefix="form" %><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Index</title>
</head>
<body>
	<h1>${welcomeMsg}</h1>
	<h2>Student:</h2>
	<p>
		ID: ${student.id}<br />
		Name: ${student.name}<br />
		Address: ${student.address.city}
	</p>
</body>
</html>
</compress:html>