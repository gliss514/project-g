<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<gtag:container>
	<gtag:form modelAttribute="customer" caption="gres.title.search.customer">
		<button type="button" onclick="load('createCustomer.g');"
			class="btn btn-default">
			<span class="glyphicon glyphicon-plus"></span> ${caption}
		</button>
		<br />
		<br />
		<table class="table table-bordered" id="customer">
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${results}">
					<tr>
						<td>${customer.code}</td>
						<td>${customer.name}</td>
						<td><gtag:action icon="pencil" tooltip="tooltip.update"
								url="updateCustomer.g?id=${customer.id}"></gtag:action> &nbsp; <gtag:action
								icon="trash" tooltip="tooltip.delete"
								url="deleteCustomer.g?id=${customer.id}"></gtag:action></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</gtag:form>
</gtag:container>