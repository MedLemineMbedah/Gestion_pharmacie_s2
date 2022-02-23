<%--  <%
if((String)session.getAttribute("nom")==null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
	dispatcher.forward(request, response);
	}
%>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Todo Management Application</title>

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
            <h1 class="m-0 text-dark">Pharmacie</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#"> Pharmacie</a></li>
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
            			Faire une vente
            		</c:if>
                </h3>
                <c:if test="${produit != null}">
					<form action="vente?type=/update" method="post">
				</c:if>
				<c:if test="${produit == null}">
					<!-- <form action="insert" method="post">medicament?type=/new
				 -->
				 <form action="vente?type=/insert" method="post">
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
                 
                        <label>Clients</label>
                        <select  name="client" class="form-control">
                          <c:forEach var="client" items="${listClient}">
			        	<option value="${client.id}">${client.nom}</option>
			   		 </c:forEach>
                          
                        </select>
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        
                      </div>
                    </div>
                    <input type="hidden" value="1" name="id_vente">
                    <button type="submit" class="btn btn-success left">Ajouter</button>
                  </div>
               
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
							<%-- <td><c:out value="${vente.id_client}" /></td> --%>

							<%-- <td><a href="vente?type=/edit&id=<c:out value='${vente.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="vente?type=/delete&id=<c:out value='${vente.id}' />">Delete</a></td> --%>
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
