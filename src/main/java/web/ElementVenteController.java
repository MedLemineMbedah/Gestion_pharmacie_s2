package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ElementVenteDao;
import model.ElementVente;

public class ElementVenteController {

	private static final long serialVersionUID = 1L;
	private ElementVenteDao elementElementVenteDao;
	
	
	public void init() {
		elementElementVenteDao = new ElementVenteDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertElementVente(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateElementVente(request, response);
				break;
			default:
				listElementVente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listElementVente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("ElementVente Controller List");
		List<ElementVente> listElementVente = elementElementVenteDao.selectAllTs();
		request.setAttribute("listElementVente", listElementVente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ElementVente/ElementVente-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ElementVente/ElementVente-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		ElementVente existingElementVente = elementElementVenteDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ElementVente/ElementVente-form.jsp");
		request.setAttribute("ElementVente", existingElementVente);
		dispatcher.forward(request, response);
	}

	
	private void insertElementVente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("ElementVente Controller Insert ElementVente");
		int id_produit_v = Integer.valueOf( request.getParameter("id_produit_v"));
		int id_vente = Integer.valueOf( request.getParameter("id_vente"));
		
//		ElementVente newElementVente = new ElementVente(id_produit_v, id_vente);
//		elementElementVenteDao.insertT(newElementVente);
		response.sendRedirect("list");
	}

	
	private void updateElementVente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		java.util.logging.Logger.global.info("ElementVente Controller Update ElementVente");
		int id_produit_v = Integer.valueOf( request.getParameter("id_produit_v"));
		int id_vente = Integer.valueOf( request.getParameter("id_vente"));
		int id = Integer.valueOf( request.getParameter("id"));
//		ElementVente updateElementVente = new ElementVente(id,id_produit_v, id_vente);
//		elementElementVenteDao.updateT(updateElementVente);
		response.sendRedirect("list");
	}

	
	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("ElementVente Controller Delete ElementVente");

		int id = Integer.parseInt(request.getParameter("id"));
		elementElementVenteDao.deleteT(id);
		response.sendRedirect("list");
	}

}
