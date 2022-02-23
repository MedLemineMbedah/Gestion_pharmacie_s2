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

	<div class="container col">
	 <div class="">
              <div class="header">
              
                <h3 class="">
                	<c:if test="${produit != null}">
            			
            		</c:if>
					<c:if test="${produit == null}">
            			
            		</c:if>
                </h3>
                <c:if test="${produit != null}">
					<form action="vente?type=/update" method="post">
				</c:if>
				<c:if test="${produit == null}">
					
				 <form action="vente?type=/insertele" method="post">
				 </c:if>
                
              </div>
              <!-- /.card-header -->
              <div class="">
                
					<c:if test="${produit != null}">
					<input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
				</c:if>
				
				<div class="card-header">
                <h3 class="card-title">Medicament</h3>
              </div>
              <div class="container">
                <div class="row">
                <div class="col-8">
                  <select  name="produit" class="form-control ">
                          <c:forEach var="produit" items="${listProduit}">
                          <option value="${produit.id}">${produit.intitule} ! Quantité : ${produit.quantite}</option>
			       			
			    		</c:forEach>
                         </select>
                  </div>
                  <div class="col-1">
                   <input type="number" class="form-control" value="1" name="qte" placeholder="Quantite">
                  </div>
                  <div class="col-3">
                    <button type="submit" class="btn btn-success">Ajouter</button>
                  </div>
                  
                  
                </div>
				
					<input type="hidden" value="1" name="id_vente">
               
                </form>
              </div>
              <!-- /.card-body -->
            </div>
	
	</div>
	<br><br>
	<div class="container">
	<table class="table">
  <thead class="table-light">
  	<tr>
        <th >Medicament</th>
		<th>Quantite</th>
		<th >Prix Total</th>
	</tr>
  </thead>
  <tbody>
  	<form action="vente?type=/beforInsertele" method="post">
   <c:forEach var="elm" items="${listelv}">

						<tr>
							
							<td><c:out value="${elm.produit.intitule}" /></td>
							<td><c:out value="${elm.quantite}" /></td>
							<td><c:out value="${elm.quantite * elm.produit.prix}" /></td>
							<br />
							
					</c:forEach>
					
  </tbody>
</table>

					<button type="submit" class=" btn btn-success btn float-right">valide</button>
					
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