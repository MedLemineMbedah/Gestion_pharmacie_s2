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

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List des Fournisseur</h3>
			<hr>
			 <div class="card">
            <div class="card-header">
              <h3 class="card-title">List des Fournisseur</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  	<th>nom</th>
						<th>prenom</th>
						<th>telephone</th>
						<th>Actions</th>
                </tr>
                </thead>
                <tbody>
                
					<c:forEach var="f" items="${listFournisseur}">

						<tr>
							<td><c:out value="${f.nomf}" /></td>
							<td><c:out value="${f.prenomf}" /></td>
							<td><c:out value="${f.telephone}" /></td>
							
							<td>
							 <a class="btn btn-info btn-sm" href="fournisseurs?type=/edit&id=<c:out value='${f.id}' />">
                              <i class="fas fa-pencil-alt">
                              </i>
                             
                          </a>
                          
                          </td>

							
						</tr>
					</c:forEach>
               </tbody>
                <tfoot>
                <tr>
                  <th>nom</th>
						<th>prenom</th>
						<th>telephone</th>
						<th>Actions</th>
                </tr>
                </tfoot>
              </table>
            </div>
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
