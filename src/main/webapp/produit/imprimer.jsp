
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="fr" dir="ltr">


<head>
  <meta charset="utf-8">
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
<body>

  <br><br><br>
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
              <input type="button" value="Télécharger" class="noprint" onclick='window.print();'>
              
</td>
					
 
              <td>

                
              </td>
            </tr>
          </table>
        </td>
      </tr>

      <tr class="information">
        <td colspan="2">
        	<table class="table table-bordered" id="table">
				<thead>
					<tr>
						<th>Libelle</th>
						<th>date d'expiration</th>
						<th>Quantite</th>
						<th>Prix</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Produit produit: produits) {  -->
					<c:forEach var="produit" items="${listProduit}">

						<tr data-prix="${produit.prix}">
							<th><c:out value="${produit.intitule}" /> </th>
							<th><c:out value="${produit.date_exp}" /> </th>
							<th><c:out value="${produit.quantite}" /> </th>
							<th><c:out value="${produit.prix}"/>  MRU</th>
							
						</tr>
					</c:forEach>
					
					<!-- } -->
				</tbody>

			</table>
		</td>
      </tr>
      <tr class="total">
      <td></td>
      <td>
        Total MRU : <input type="text" readonly name="total" id="total"/> 
      </td>
    </tr>
      
    </table>
  </div>
  <br><br>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function (){
		
	
	        let montant_Total = 0;
	        let table = $("#table");
	          // 4i boucle
	        table.find("tbody tr").each(function () {
	            let prixTotal = $(this).data('prix') ;
	            montant_Total = montant_Total + prixTotal;
	
	        });
	
	        console.log(montant_Total)
	        $("#total").val(montant_Total)
	})

</script>
  
</body>
</html>