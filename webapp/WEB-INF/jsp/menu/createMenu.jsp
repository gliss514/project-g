<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu" caption="gres.title.create.menu">
			<gtag:textinput name="name" label="label.name" mandatory="yes" placeholder="Name"></gtag:textinput>
			<gtag:textinput name="code" label="label.code" mandatory="yes" placeholder="Code"></gtag:textinput>
			<gtag:select items="${menuCategory}" name="category" label="gres.label.category" mandatory="yes"></gtag:select>
			<gtag:numberinput name="price" label="gres.label.price" mandatory="yes"></gtag:numberinput>
<%-- 			<gtag:fileinput name="image" label="gres.label.image"></gtag:fileinput> --%>
			<gtag:buttoncontainer>
				<gtag:submit/>
				<gtag:button href="main.g" label="label.cancel"/>
			</gtag:buttoncontainer>
		</gtag:form>
	</div>
</body>
<script type="text/javascript">
	$('#appetizer-container').load('menuAppetizer.g');
	$('#main-container').load('menuMain.g');
	$('#sides-container').load('menuSides.g');
	$('#desserts-container').load('menuDesserts.g');
	$('#beverage-container').load('menuBeverage.g');
</script>
</html>