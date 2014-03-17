<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu" caption="gres.title.manage.menu">
			<gtag:buttoncontainer>
				<gtag:button href="#" onclick="load('createMenu.g');" label="label.add"/>
			</gtag:buttoncontainer>
		</gtag:form>
	</div>
</body>
</html>