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

import dao.impl.ClientDao;
import dao.impl.FournisseurDao;
import dao.impl.ProduitDaoImpl;
import dao.impl.UserDao;
import model.Clients;
import model.Fournisseur;
import model.Produit;
import model.User;

@WebServlet("/index")
public class IndexController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private FournisseurDao f;
	private ProduitDaoImpl	produitDao;
	private ClientDao c;
	private int nbclient =0;
	

	public void init() {
	 f= new FournisseurDao();
	 produitDao = new ProduitDaoImpl();
	 userDao = new UserDao();
     c = new ClientDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			try {
			
				showNewForm1(request, response);
				
				showNewForm2(request, response);
				
				showNewForm3(request, response);
				
				 showInfoForm4(request, response);
				 
				 showInfoForm5(request, response);
					
				// RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/selectFournisseur.jsp");
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showInfoForm5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = userDao.selectAllTs();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/principal.jsp");
		dispatcher.forward(request, response);
	
	}

	private void showNewForm1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Fournisseur> listFournisseur = f.selectAllTs();
		request.setAttribute("listFournisseur", listFournisseur);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/principal.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private void showNewForm2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Clients> listeclient = c.selectAllTs();
		
		for (Clients clients : listeclient) {
			nbclient++;
		}
		System.out.println("i valeur "+nbclient);
		request.setAttribute("nbclient", nbclient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/principal.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private void showNewForm3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = userDao.selectAllTs();
		request.setAttribute("listuser", listUser );
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/principal.jsp");
		dispatcher.forward(request, response);
	
	}

	private void showInfoForm4(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show  dashbord ");
		List<Produit> listeProduit =   produitDao.selectAllTs();
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashbord/principal.jsp");
		request.setAttribute("listeProduit", listeProduit);
		dispatcher.forward(request, response);
	
	}

	public int getNbclient() {
		return nbclient;
	}

	public void setNbclient(int nbclient) {
		this.nbclient = nbclient;
	}

	
}
