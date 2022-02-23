
<%@page import="model.User"%>
<%@page import="dao.impl.UserDao"%>
<%@page import="model.Fournisseur"%>
<%@page import="dao.impl.FournisseurDao"%>
<%@page import="model.Clients"%>
<%@page import="java.util.ArrayList" %>
<%@page import="dao.impl.ClientDao"%>

<%@page import="dao.impl.ProduitDaoImpl"%>
<%@page import="model.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de  Pharmacie</title>
<%@ include file="/include/css.jsp"%>
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
              <li class="breadcrumb-item"><a href="#"> Tableau de bord</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>
                	
                	 <%
                	 FournisseurDao f;
						f = new FournisseurDao ();
						List<Fournisseur> fournisseur = f.selectAllTs();
                		int j=0;
        				for (Fournisseur Fournisseurs : fournisseur) {
 					j++;
    		} %>
    				<%= j %>
                </h3>

                <p>Fournisseur</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="fournisseurs"" class="small-box-footer">Details <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3><%
	                ClientDao c= new ClientDao();
					List<Clients> client= c.selectAllTs();
	                int z=0;
	        		for (Clients cli : client) {
	 				z++;
	    		} %>
    				<%= z %>
                </h3>
    				<sup style="font-size: 20px"></sup></h3>

                <p>Clients</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="clients" class="small-box-footer">Details<i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-warning">
              <div class="inner">
                <h3>
             <%--   <%  
                 UserDao u;
				u = new UserDao();
				List<User> user= u.selectAllTs();
                int k=0;
        		for (User Users : user) {
 				k++;
    		} %>
    				<%= k %>
             --%>    </h3>

                <p>Utilisateur</p>
              </div>
              <div class="icon">
                <i class="ion ion-person-add"></i>
              </div>
              <a href="#" class="small-box-footer">Details<i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-danger">
              <div class="inner">
                <h3>
                	<%
	                ProduitDaoImpl p;
					p = new ProduitDaoImpl();
					List<Produit> produit= p.selectAllTs();
	                int y=0;
	        		for (Produit Produit : produit) {
	 				y++;
	    		} %>
    				<%= y %>
                </h3>

                <p>Produits</p>
              </div>
              <div class="icon">
                <i class="ion ion-pie-graph"></i>
              </div>
              <a href="medicament" class="small-box-footer">Details <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<%-- <h1>Page D'acceuille</h1>


	<a href="login" class="btn btn-outline-primary">Login</a><br/><br/>	
	<a href="register" class="btn btn-outline-danger">Register</a>
	<a href="medicament" class="btn btn-outline-danger">MEdicament</a>
	<a href="vente" class="btn btn-outline-danger">Vente</a>
	<a href="clients" class="btn btn-outline-danger">Clients</a>
	<a href="achat" class="btn btn-outline-danger">achat</a>
	--%>

	</div>
          <!-- ./col -->
        </div>

            <!-- /.card -->
          </section>
          <!-- right col -->
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