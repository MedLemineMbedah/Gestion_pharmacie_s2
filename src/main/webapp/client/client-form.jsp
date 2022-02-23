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
<title>Clients</title>
<%@ include file="/include/css.jsp"%>
</head>

</head>
<body>
	<div class="wrapper">
	
		<%@ include file="/include/header.jsp"%>
		<%@ include file="/include/sedebar.jsp"%>
		<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark"></h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#"> Clients</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${client != null}">
				<div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Modifier le Client</h3>
              </div>
              <form  action=""clients?type=/update" method="post" role="form">
				</c:if>
				<c:if test="${client == null}">
					<div class="card card-primary">
		              <div class="card-header">
		                <h3 class="card-title">Ajouter Un Nouveau  Client</h3>
		              </div>
					<!-- <form action="insert" method="post">medicament?type=/new
				 -->
				 
				 <form  action="clients?type=/insert" method="post" role="form">
				 </c:if>

				

				<c:if test="${client != null}">
					<input type="hidden" name="id" value="<c:out value='${client.id}' />" />
				</c:if>
 				
 				 <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1"> Nom</label>
                    <input type="text" value="<c:out value='${client.nom}' />" class="form-control"
						name="nom" required="required"  id="exampleInputEmail1" placeholder="Nom....">
                  </div>
				
				<div class="form-group">
                    <label for="exampleInputEmail1"> Prenom</label>
                    <input type="text"
						value="<c:out value='${client.prenom}' />" class="form-control"
						name="prenom" required="required"  id="exampleInputEmail1" placeholder="Prenom...">
                </div>
				
				<div class="form-group">
                    <label for="exampleInputEmail1">Telephone</label>
                    <input type="number" value="<c:out value='${client.telephone}' />" class="form-control"
						name="tel" required="required"  id="exampleInputEmail1" placeholder="Numero telephone" min="8">
                </div>				
				
				
				</div>
				
				
				<div class="card-footer">
                  <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
				</form>
				</div>
			</div>
		</div>
	</div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
	</div>
      <%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%>  
 					
</body>
</html>
