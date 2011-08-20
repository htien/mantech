<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Success page</title>
</head>
<body>
	User Detail
	<hr/>
	<table>
		<tr><td>User Name:</td><td>${userInfo.name}</td></tr>
		<tr><td>Gender:</td><td>${userInfo.gender}</td></tr>
		<tr><td>Country:</td><td>${userInfo.country}</td></tr>
		<tr><td>About You:</td><td>${userInfo.aboutYou}</td></tr>
		<tr><td>Community:</td><td>${userInfo.community[0]} ${userInfo.community[1]} ${userInfo.community[2]}</td></tr>
		<tr><td>Mailing List:</td><td>${userInfo.mailingList}</td></tr>
	</table>
</body>
</html>