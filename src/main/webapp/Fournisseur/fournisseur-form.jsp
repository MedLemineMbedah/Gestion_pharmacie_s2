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
<title>Fournisseur</title>
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
              <li class="breadcrumb-item"><a href="#"> Fournisseur</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${fournisseur != null}">
				<div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Modifier  Fournisseur</h3>
              </div>
				<form  action="fournisseurs?type=/update" method="post" role="form">
				</c:if>
				<c:if test="${fournisseur == null}">
				<div class="card card-primary">
		              <div class="card-header">
		                <h3 class="card-title">Ajout Fournisseur</h3>
		              </div>
					<!-- <form action="insert" method="post">medicament?type=/new
				 -->
				 
				 <form  action="fournisseurs?type=/insert" method="post" role="form">
				 </c:if>

		
				<c:if test="${fournisseur != null}">
					<input type="hidden" name="id" value="<c:out value='${fournisseur.id}' />" />
				</c:if>
 
	
				 <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Nom du fournsseur</label>
                    <input name="nom" type="text" class="form-control" name="intitule" value="<c:out value='${fournisseur.nomf}' />" required="required"  id="exampleInputEmail1" placeholder="Nom produit">
                  </div>
				
				<div class="form-group">
                    <label for="exampleInputEmail1">Prenom</label>
                    <input type="text" name="prenom" class="form-control" name="quantite" value="<c:out value='${fournisseur.prenomf}' />" required="required"  id="exampleInputEmail1" placeholder="prenom">
                </div>
				
				
				<div class="form-group">
                    <label for="exampleInputEmail1">Telephone</label>
                    <input type="number"  name="telephone" class="form-control" name="prix" value="<c:out value='${fournisseur.telephone}' />" required="required"  id="exampleInputEmail1" placeholder="telephone">
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
