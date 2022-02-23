<% if((String)session.getAttribute("nom")==null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
	dispatcher.forward(request, response);
	}
%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>>Achat</title>

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
              <li class="breadcrumb-item"><a href="#"> Achat</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <div class ="container">
		<div class="card">
              <div class="card-header">
                <h3 class="card-title">Details</h3>
              </div>
              <!-- /.card-header -->
             <hr>
			<h4><c:out value="${vente.intitule}"></c:out></h4>
			<br>
                <table class="table table-sm">
                  <thead>
                    <tr>
                      <th>Intitule</th>
						<th>Medicament</th>
						<th>Qte</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                   
					<c:forEach var="elm" items="${elementVente}">

						<tr>
							<td><c:out value="${elm.achat.intitule}" /></td>
							<td><c:out value="${elm.produit.intitule}" /></td>
							<td><c:out value="${elm.quantite}" /></td>
							<%-- <td><c:out value="${vente.id_client}" /></td>

							<td><a href="vente?type=/info&id=<c:out value='${vente.id}' />">Info</a></td>
	 --%>
						</tr>
					</c:forEach>
                  </tbody>
                </table>
              
              <!-- /.card-body -->
            </div>
            </div>
<!-- fin -->
<!-- /.card-body -->
          </div>
          <!-- /.card -->
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