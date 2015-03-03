<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="gtag"%>

<gtag:container>
	<gtag:form modelAttribute="salesContract" caption="gres.title.search.contract">
		<button type="button" onclick="load('createSalesContract.g');"
			class="btn btn-default">
			<span class="glyphicon glyphicon-plus"></span> ${caption}
		</button>
		<br />
		<br />
		<table class="table table-bordered" id="salesContract">
			<thead>
				<tr>
					<th>Customer Name</th>
					<th>Date From</th>
					<th>Date To</th>
					<th>Days Remaining</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="salesContract" items="${results}">
					<tr>
						<td>${salesContract.customer.name}</td>
						<td><fmt:formatDate value="${salesContract.dateFrom}" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${salesContract.dateTo}" pattern="dd/MM/yyyy" /></td>
						<td>${salesContract.daysRemaining}</td>
						<td><gtag:action icon="pencil" tooltip="tooltip.update"
								url="updateSalesContract.g?id=${salesContract.id}"></gtag:action> &nbsp; <gtag:action
								icon="trash" tooltip="tooltip.delete"
								url="deleteSalesContract.g?id=${salesContract.id}"></gtag:action></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</gtag:form>
</gtag:container>