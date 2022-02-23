package web;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ProduitDaoImpl;
//import dao..ProduitDaoImpl;
import model.Produit;
import model.User;

@WebServlet("/medicament")
public class ProduitController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	private ProduitDaoImpl produitDao;
	
	public void init() {
		produitDao = new ProduitDaoImpl();
		 System.out.println("IS INIT");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("doget produi avant try POST");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action="";
		if(request.getParameter("type")!=null)
			action= request.getParameter("type");
			
		
           System.out.println("doget produi avant try");
           System.out.println("action "+action);
           
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProduit(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProduit(request, response);
				break;
			case "/imprimer":
				imprimer(request, response);
				break;
			default:
				listProduit(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void imprimer(HttpServletRequest request, HttpServletResponse response)	throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		java.util.logging.Logger.global.info("Produit Controller List");
		List<Produit> listProduit = produitDao.selectAllTs();
		request.setAttribute("listProduit", listProduit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("produit/imprimer.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void listProduit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Produit Controller List");
		List<Produit> listProduit = produitDao.selectAllTs();
		request.setAttribute("listProduit", listProduit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("produit/produit-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("produit/produit-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		Produit existingProduit = produitDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("produit/produit-form.jsp");
		request.setAttribute("produit", existingProduit);
		dispatcher.forward(request, response);
	}

	private void insertProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Prduit Controller Insert Produit");
		String intitule = request.getParameter("intitule");
	//	int quantite = Integer.parseInt( request.getParameter("quantite"));
		//Produit newProduit = new Produit(intitule, quantite, LocalDate.now());
		//Long id = Long.parseLong( request.getParameter("id"));LocalDate.now()
	//	LocalDate dateExp = LocalDate.parse(request.getParameter("date_exp"));
	//	float prix =Float.valueOf( request.getParameter("prix"));
	//	int prix = Integer.parseInt( request.getParameter("prix"));
		
		//int id = Integer.parseInt( request.getParameter("id"));
		float p = 0.0f;
		LocalDate lc = null;
		
		Produit newProduit = new Produit(intitule, 0, lc, p);
		System.out.println("nom P:"+newProduit.getIntitule());
		produitDao.insertT(newProduit);
		response.sendRedirect("medicament");
	}

	private void updateProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		java.util.logging.Logger.global.info("Prduit Controller Update Produit");
		String intitule = request.getParameter("intitule");
		int quantite = Integer.parseInt( request.getParameter("quantite"));
		//Produit newProduit = new Produit(intitule, quantite, LocalDate.now());
		//Long id = Long.parseLong( request.getParameter("id"));LocalDate.now()
		LocalDate dateExp = LocalDate.parse(request.getParameter("date_exp"));
		float prix =Float.valueOf( request.getParameter("prix"));
	//	int prix = Integer.parseInt( request.getParameter("prix"));
		
		//int id = Integer.parseInt( request.getParameter("id"));
		
		Produit updateProduit = new Produit(id,intitule, quantite, dateExp,prix);
		produitDao.updateT(updateProduit);
		System.out.println("3ageb updateProduit");
		

		response.sendRedirect("medicament");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Prduit Controller Delete Produit");
		int id = Integer.parseInt(request.getParameter("id"));
		produitDao.deleteT(id);
		response.sendRedirect("medicament");
	}
	
	
	

}