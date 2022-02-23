package web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.FournisseurDao;
import model.Clients;
import model.Fournisseur;

@WebServlet("/fournisseurs")
public class FournisseurController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FournisseurDao fournisseurDAO;
	
	public void init() {
		fournisseurDAO = new FournisseurDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action="";
		if(request.getParameter("type")!=null)
			action= request.getParameter("type");
			
		
           System.out.println("doget achat avant try");
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
			default:
				listProduit(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listProduit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Produit Controller List");
		List<Fournisseur> listFournisseur = fournisseurDAO.selectAllTs();
		request.setAttribute("listFournisseur", listFournisseur );
		RequestDispatcher dispatcher = request.getRequestDispatcher("Fournisseur/fournisseur-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Fournisseur/fournisseur-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		Fournisseur existingFournisseur = fournisseurDAO.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Fournisseur/fournisseur-form.jsp");
		request.setAttribute("fournisseur", existingFournisseur);
		dispatcher.forward(request, response);
	}

	private void insertProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Prduit Controller Insert Produit");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int tel = Integer.parseInt( request.getParameter("telephone"));
		Fournisseur newFournisseur = new Fournisseur(nom, prenom,tel );
		fournisseurDAO.insertT(newFournisseur);
		response.sendRedirect("fournisseurs");
	}

	private void updateProduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Prduit Controller Update Produit");
		int id = Integer.parseInt( request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int tel = Integer.parseInt( request.getParameter("telephone"));
		Fournisseur newFournisseur = new Fournisseur(id,nom,prenom,tel);
		fournisseurDAO.updateT(newFournisseur);;

		response.sendRedirect("fournisseurs");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Prduit Controller Delete Produit");

		int id = Integer.parseInt(request.getParameter("id"));
		fournisseurDAO.deleteT(id);
		response.sendRedirect("fournisseurs");
	}
	
	
	
}
