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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>

	<body>
	    <div class="site-wrapper">

            <div class="site-wrapper-inner">

                <div class="cover-container">
                    <div id="header">
                        <tiles:insertAttribute name="menu" />
                    </div>
                    <div id="body">
                        <tiles:insertAttribute name="body" />
                    </div>
                    <div id="footer">
                        <tiles:insertAttribute name="footer" />
                    </div>
                </div>
              </div>
        </div>

	</body>
</html>