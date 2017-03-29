<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:getAsString name="title" /></title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet"/>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
		<script src="/javascript/script.js"></script>
		<script src="/javascript/delete.js"></script>
	</head>

	<body>
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>