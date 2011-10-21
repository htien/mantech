<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@
taglib uri="http://www.springframework.org/tags/form" prefix="f"%><%@
taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress"%><%@
taglib uri="http://code.google.com/p/springnet" prefix="jtien"%><compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true"
	removeIntertagSpaces="true">

<c:set var="templateDir"><jtien:settings key="template.dir"/></c:set>
<c:set var="templateName"><jtien:settings key="template.name"/></c:set>
<c:set var="dateTimeFormat"><jtien:settings key="dateTime.format"/></c:set>
<c:set var="dateFormat"><jtien:settings key="date.format"/></c:set>
<c:set var="timeFormat"><jtien:settings key="time.format"/></c:set>
<c:set var="language"><jtien:settings key="i18n.default"/></c:set>
<c:set var="isAdmin" value="${userSession.user.role.id == 1}"/>
<c:set var="isTechnician" value="${userSession.user.role.id == 2}"/>
<c:set var="isEmployee" value="${userSession.user.role.id == 3}"/>
</compress:html>