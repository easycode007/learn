<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:getAsString name="title" /></title>
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/assets/css/ie10-viewport-bug-workaround.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/cover.css'/>" rel="stylesheet"/>
		<script src="/assets/js/ie-emulation-modes-warning.js"></script>
	</head>

	<body>
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>
		<section id="left-side-content">
            <tiles:insertAttribute name="leftSide" />
        </section>
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
        <section id="right-side-content">
            <tiles:insertAttribute name="rightSide" />
        </section>
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>