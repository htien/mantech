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
		<tr><td>User Name:</td><td>${user.name}</td></tr>
		<tr><td>Gender:</td><td>${user.gender}</td></tr>
		<tr><td>Country:</td><td>${user.country}</td></tr>
		<tr><td>About You:</td><td>${user.aboutYou}</td></tr>
		<tr><td>Community:</td><td>${user.community[0]} ${user.community[1]} ${user.community[2]}</td></tr>
		<tr><td>Mailing List:</td><td>${user.mailingList}</td></tr>
	</table>
</body>
</html>