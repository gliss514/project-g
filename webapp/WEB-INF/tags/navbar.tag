<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="items" required="true" type="java.util.List" rtexprvalue="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand glyphicon glyphicon-home" href="#" onclick="load('index.g');"></a>
	</div>
	<ul class="nav navbar-nav">
		<c:forEach var="entry" items="${items}">
			<c:if test="${empty entry.childs}">
				<c:if test="${!empty entry.uri}">
					<li><a onclick="load('${entry.uri}')"><spring:message code="${entry.label}" text="${entry.label}" /></a></li>
				</c:if>
				<c:if test="${!empty entry.href}">
					<li><a href="${entry.href}"><spring:message code="${entry.label}" text="${entry.label}" /></a></li>
				</c:if>
			</c:if>
			<c:if test="${!empty entry.childs}">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="${entry.label}" text="${entry.label}" /><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<c:forEach var="childs" items="${entry.childs}">
							<c:if test="${!empty childs.uri}">
								<li><a onclick="load('${childs.uri}')"><spring:message code="${childs.label}" text="${childs.label}" /></a></li>
							</c:if>
							<c:if test="${!empty childs.href}">
								<li><a href="${childs.href}"><spring:message code="${childs.label}" text="${childs.label}" /></a></li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</nav>