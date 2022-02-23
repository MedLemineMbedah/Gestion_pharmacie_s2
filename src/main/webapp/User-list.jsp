<%
if((String)session.getAttribute("nom")==null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
	dispatcher.forward(request, response);
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Todo Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Todo
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List des Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/register/new"
					class="btn btn-success">Ajouter User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Intitule</th>
						<th>Date Exp</th>
						<th>Quantite</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Produit produit: produits) {  -->
					<c:forEach var="produit" items="${listProduit}">

						<tr>
							<td><c:out value="${user.intitule}" /></td>
							<td><c:out value="${user.date_exp}" /></td>
							<td><c:out value="${user.quantite}" /></td>

							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
