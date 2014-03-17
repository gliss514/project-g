<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="label" required="false" type="java.lang.String"%>
<%@ attribute name="mandatory" required="false" type="java.lang.String"%>
<%@ attribute name="placeholder" required="false" type="java.lang.String"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<div class="form-group">
	<gtag:label label="${label}" mandatory="${mandatory}" />
	<div class="col-md-8 col-sm-pad">
		<form:input path="${name}" id="${name}" class="form-control" placeholder="${placeholder}" />
		<form:errors path="${name}" cssClass="error" />
	</div>
</div>