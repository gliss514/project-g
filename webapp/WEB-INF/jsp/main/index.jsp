<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="caption.main" text="caption.main" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link href="<spring:theme code="css"/>" rel="stylesheet" type="text/css" />
<link href="projg/css/projg.css" rel="stylesheet">
</head>
<body>
	<gtag:navbar title="gres.navbar.title" items="${navbarItems}"/>
	<div id="workspace"></div>
	<div class="container-fluid">
		<p align="center">
			<font size="-2">&nbsp;&nbsp;Project G Version 1.0. Copyright (c) 2014, All Rights Reserved.</font>
		</p>
	</div>
</body>
<script src="projg/js/jquery.js"></script>
<script src="projg/js/jquery.form.js"></script>
<script src="projg/js/projg.js" type="text/javascript"></script>
<script src="themes/bootstrap/js/bootstrap.js"></script>
<script>
	$("#workspace").load("main.g");
</script>
</html>
