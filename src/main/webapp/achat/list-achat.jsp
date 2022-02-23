<%
if((String)session.getAttribute("nom")==null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
	dispatcher.forward(request, response);
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Fournisseur" %>
<%@page import="model.Achats" %>

<% ArrayList listVente = (ArrayList)request.getAttribute("listVente"); %>
<% ArrayList clientList = (ArrayList)request.getAttribute("clientList"); %>
<html>
<head>
<title>Achat</title>

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
              <li class="breadcrumb-item"><a href="#"> Achats</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste des Achats</h3>
			<hr>
			 <div class="card">
            <div class="card-header">
              <h3 class="card-title">Liste des Achats</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                <th>Intitule</th>
						<th>Date</th>
						<th>Nom client</th>
						<th>Actions</th>
                </tr>
                </thead>
                <tbody>
               		 <%
					
					for(int i = 0,j=0; i < listVente.size(); i++) { %>
            	<tr>      
           			
                <% Achats v= (Achats)listVente.get(i);%>
                <td><%= v.getIntitule() %></td>
                <td><%= v.getDate() %></td>
                <td><%  Fournisseur c=(Fournisseur)clientList.get(j);
                		if(v.getId_f()==c.getId()){
                	%><%= c.getNomf()%>
                		<% }
                		else{
                			j++;
                			Fournisseur c1=(Fournisseur)clientList.get(j);%>
                		<%= c1.getNomf() %>
                		<% 
                		}
                		%>
                
                <td> <a class="btn btn-info" href="achat?type=/info&id=<c:out value="<%= v.getId() %>" />">
                              <i class="fas fa-eye">
                              </i>
                          </a></td>
            </tr>
       			<% } %>
        
					 
                </tbody>
                <tfoot>
                <tr>
                  <th>Intitule</th>
						<th>Date</th>
						<th>Nom client</th>
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