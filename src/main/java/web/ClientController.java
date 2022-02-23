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


import dao.impl.ClientDao;
import model.Clients;
import model.Produit;
@WebServlet("/clients")
public class ClientController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private ClientDao clientDao;
	
	
	public void init() {
		clientDao = new ClientDao();
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
				insertClient(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateClient(request, response);
				break;
			default:
				listClient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Client Controller List");
		List<Clients> listClient = clientDao.selectAllTs();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client/client-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("client/client-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		Clients existingClient = clientDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client/client-form.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);
	}
	

	private void insertClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Client Controller Insert Client");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int tel = Integer.parseInt( request.getParameter("tel"));
		int id_utilisateur = 1;
		//		Long id_vente = Long.parseLong( request.getParameter("id_vente"));
	
		Clients newClient = new Clients(nom,prenom,tel);
		clientDao.insertT(newClient);
		response.sendRedirect("clients");
	}
	

	
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int tel = Integer.parseInt( request.getParameter("tel"));
		int id_utilisateur = 1;
//	Long id_vente = Long.parseLong( request.getParameter("id_vente"));	
		Clients updateClient = new Clients(id,nom,prenom,tel);
		clientDao.updateT(updateClient);
		response.sendRedirect("clients");
	}
	

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Client Controller Delete Client");
		int id = Integer.parseInt(request.getParameter("id"));
		clientDao.deleteT(id);
		response.sendRedirect("clients");
	}
	

}
