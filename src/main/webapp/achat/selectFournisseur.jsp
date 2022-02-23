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
<title>	Achat</title>

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
              <li class="breadcrumb-item"><a href="#">Achat</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
	<%--Debut --%>
		<div class="container col-md-5">
	 <div class="card card-warning">
              <div class="card-header">
                <h3 class="card-title">
                	<c:if test="${produit != null}">
            			Modifier une vente
            		</c:if>
					<c:if test="${produit == null}">
            			Faire un Achat
            		</c:if>
                </h3>
                <c:if test="${produit != null}">
					<form action="vente?type=/update" method="post">
				</c:if>
				<c:if test="${produit == null}">
					<!-- <form action="insert" method="post">medicament?type=/new
				 -->
				 <form action="achat?type=/insert" method="post">
				 </c:if>
               
                
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                
					<c:if test="${produit != null}">
					<input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
				</c:if>
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- select -->
                      <div class="form-group">
                      
                        <label>Fournisseur</label>
                        <select  name="fournisseur" class="form-control">
                          <c:forEach var="fournisseur" items="${listFournisseur}">
			        	<option value="${fournisseur.getId()}">${fournisseur.getNomf()}</option>
			   		 </c:forEach>
                          
                        </select>
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        
                      </div>
                    </div>
                    <button type="submit" class="btn btn-success left">Ajouter</button>
                  </div>
					<input type="hidden" value="1" name="id_vente">
               
                </form>
              </div>
              <!-- /.card-body -->
            </div>
	
	</div>
	<%--Fin --%>
	<%--debut --%>
	<div class="card">
	  	
                <table class="table table-striped">
                  <thead>
                    <tr>
                    <th >Medicament</th>
						<th>Quantite</th>
						<th >Prix Total</th>
						
                    
                    </tr>
                  </thead>
                  <tbody>
                  
				 <c:forEach var="elm" items="${listelv}">

						<tr>
							
							<td><c:out value="${elm.produit.intitule}" /></td>
							<td><c:out value="${elm.quantite}" /></td>
							<td><c:out value="${elm.quantite * elm.produit.prix}" /></td>
							<br />
							
						</tr>
					</c:forEach>
					
						
                  </tbody>
                </table>
              
              <!-- /.card-body -->
            </div>
	<%--fin --%>
	
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
