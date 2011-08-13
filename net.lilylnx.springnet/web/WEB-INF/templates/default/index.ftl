<#ftl strip_whitespace=true>
<@compress single_line=true>
<?xml version="1.0" encoding="UTF-8" ?>
<#import "spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SpringNet</title>
</head>
<body>
	<p>${welcomeMsg}</p>
	<#list listNames as name>
		<p>${name_index + 1}. ${name}<#if name_has_next>,</#if></p>
	</#list>
	<#assign ext='.htm' />
	<@spring.url '/index${ext}' />
</body>
</html>
</@compress>