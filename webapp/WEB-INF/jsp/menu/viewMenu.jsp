<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gtag" tagdir="/WEB-INF/tags"%>

<html>
<body>
	<div class="glass container">
		<gtag:form modelAttribute="menu" caption="gres.title.manage.menu">
			<gtag:textinput name="name" label="label.name" mandatory="yes" placeholder="Name"></gtag:textinput>
			<gtag:textinput name="code" label="label.code" mandatory="yes" placeholder="Code"></gtag:textinput>
			<gtag:select items="${menuCategory}" name="category" label="gres.label.category" mandatory="yes"></gtag:select>
			<gtag:buttoncontainer>
				<gtag:submit></gtag:submit>
			</gtag:buttoncontainer>
		</gtag:form>
		<hr/>
		<button type="button" onclick="load('createMenu.g');" class="btn btn-default"><span class ="glyphicon glyphicon-plus"></span></button>
		<c:if test="${empty results}">
			<div>
				No records found.
			</div>
		</c:if>
		<c:if test="${!empty results}">
			<br><br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Code</th>
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="menu" items="${results}">
						<tr>
							<td>${menu.code}</td>
							<td>${menu.name}</td>
							<td>${menu.category}</td>
							<td>${menu.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>