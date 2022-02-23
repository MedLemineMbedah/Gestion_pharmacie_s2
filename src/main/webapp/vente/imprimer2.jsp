 <%
if((String)session.getAttribute("nom")==null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
	dispatcher.forward(request, response);
	}
%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Vente" %>

<% String nomC = (String)request.getAttribute("nomClient"); %>
<% Vente v = (Vente)request.getAttribute("existingVente"); %>
<% float total = (float)request.getAttribute("total"); %>
<html>
<head>
<title>Facture imprimer</title>

<%@ include file="/include/css.jsp"%>
  <style>
    @page {
      size: A4;
      margin: 1cm;

      @frame footer {
        -pdf-frame-content: footerContent;
        bottom: 0cm;
        margin-left: 9cm;
        margin-right: 9cm;
        height: 1cm;
      }
    }

    .invoice-box {
      max-width: 800px;
      margin: auto;
      padding: 30px;
      border: 1px solid #eee;
      box-shadow: 0 0 10px rgba(0, 0, 0, .15);
      font-size: 16px;
      line-height: 24px;
      font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
      color: #555;
    }

    .invoice-box table {
      width: 100%;
      line-height: inherit;
      text-align: left;
    }

    .invoice-box table td {
      padding: 5px;
      vertical-align: top;
    }

    .invoice-box table tr td:nth-child(2) {
      text-align: right;
    }

    .invoice-box table tr.top table td {
      padding-bottom: 20px;
    }

    .invoice-box table tr.top table td.title {
      font-size: 45px;
      line-height: 45px;
      color: #333;
    }

    .invoice-box table tr.information table td {
      padding-bottom: 40px;
    }

    .invoice-box table tr.heading td {
      background: #eee;
      border-bottom: 1px solid #ddd;
      font-weight: bold;
    }

    .invoice-box table tr.details td {
      padding-bottom: 20px;
    }

    .invoice-box table tr.item td {
      border-bottom: 1px solid #eee;
    }

    .invoice-box table tr.item.last td {
      border-bottom: none;
    }

    .invoice-box table tr.total td:nth-child(2) {
      border-top: 2px solid #eee;
      font-weight: bold;
    }

    @media only screen and (max-width: 600px) {
      .invoice-box table tr.top table td {
        width: 100%;
        display: block;
        text-align: center;
      }

      .invoice-box table tr.information table td {
        width: 100%;
        display: block;
        text-align: center;
      }
    }

    /** RTL **/
    .rtl {
      direction: rtl;
      font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
    }

    .rtl table {
      text-align: right;
    }

    .rtl table tr td:nth-child(2) {
      text-align: left;
    }
    @media print {
  /* style sheet for print goes here */
  .noprint {
    visibility: hidden;
  }
}
  </style>
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
            <a href="vente?type=/ajout" type="button " class="btn btn-block btn-default btn-flat"> Return Vente</a>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#"> Facture</a></li>
              <li class="breadcrumb-item active">Gestion De Pharmacie</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>



    <section class="content">
      <div class="container-fluid">
		<div class="invoice-box">
    <table cellpadding="0" cellspacing="0">
      <tr class="top">
        <td colspan="2">
          <table>
            <tr>
              <td class="title">
                <h5>Pharmacie</h5>
              </td>
              
             <!--   <td><input type="button" value="telecherge" onclick='window.print();'>
              -->
              <td>
              <input type="button" value="Imprimer" class="noprint" onclick='window.print();'>
              
</td>
					
 
              <td>

                
              </td>
            </tr>
            <tr class="information">
        <td colspan="2">
          <table>
            <tr>
              <td>
            	No. Recus : 00<%= v.getId() %><br>
                Intitile : <%= v.getIntitule() %><br>
                Patient : <%= nomC %> <br>
              </td>
			  <td>
                Date :<%= v.getDate() %><br>

              </td>
            
            </tr>
          </table>
          </table>
        </td>
      </tr>
          </table>
        </td>
      </tr>

<table  border="1" cellpadding="5" cellspacing="0" style="font-family: arial ; font-size: 12px;	text-align:left;" width="100%" id="table">
		<thead>
			<tr>
				<th width="0"> Code de produit </th>
				<th> Nom du produit </th>
				<th> Qté </th>
				<th> Prix </th>			
				<th> Montant </th>
			</tr>
		</thead>
		<tbody>
			   <c:forEach var="elm" items="${elementVente}">

						<tr data-prix="${elm.produit.getPrix() * elm.getQuantite()}"  class="record">
						
							<th><c:out value="${elm.produit.getId()}"/></th>
							<th><c:out value="${elm.produit.getIntitule()}"/></th>
							<th><c:out value="${elm.getQuantite()}" /></th>
							<th><c:out value="${elm.produit.getPrix()}" /></th>
							<th><c:out value="${elm.produit.getPrix() * elm.getQuantite()}" /></th>				
						</tr>
				</c:forEach>
				<tr>
					<td colspan="4" style=" text-align:right;"><strong style="font-size: 12px;">Total: &nbsp;</strong></td>
					<td colspan="4"><strong style="font-size: 12px;">
					 <%= total %>
					</strong></td>
				</tr>
		</tbody>
	</table>      
   </div>
      </div><!-- /.container-fluid -->
    </section>

	</div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
	</div>
      <%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%> 
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

  
</body>
</html>
