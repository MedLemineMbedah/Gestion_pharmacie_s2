package web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ProduitDaoImpl;
import dao.impl.UserDao;
import model.Produit;
import model.User;
import model.Vente;
import model.Achats;
import model.Clients;
import model.ElementAchats;
import model.ElementVente;
import model.Fournisseur;
import dao.impl.AchatDao;
import dao.impl.ClientDao;
import dao.impl.ElementAchatDao;
import dao.impl.FournisseurDao;

@WebServlet("/achat")
public class AchatsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AchatDao achatDao;
	private ProduitDaoImpl produitDao;
	private ElementAchatDao elementachatDao;
	private FournisseurDao clientDao;

	private String msg = "";

	private List<ElementAchats> listelv = new ArrayList<ElementAchats>();
	private List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>();
	private static List<Produit> listProduits = new ArrayList<Produit>();
	private int total;

	public void init() {
		achatDao = new AchatDao();
		produitDao = new ProduitDaoImpl();
		elementachatDao = new ElementAchatDao();
		clientDao = new FournisseurDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "";
		if (request.getParameter("type") != null)
			action = request.getParameter("type");

		System.out.println("doget produi avant try");
		System.out.println("action " + action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/ajout":
				showNewForm2(request, response);
				break;
			case "/insert":
				insertAchat(request, response);
				break;
			case "/insertele":
				insertElem(request, response);
				break;
			case "/delete":
				// deleteTodo(request, response);
				break;
			case "/edit":
				// showEditForm(request, response);
				break;
			case "/info":
				showInfoForm(request, response);
				break;
			case "/update":
				// updateVente(request, response);
				break;
			case "/beforInsertele":
				showNewForm3(request, response);
				break;

			case "/imprimer":
				imprimer(request, response);
				break;
			default:
				listVente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Fournisseur> listFournisseur = clientDao.selectAllTs();
		request.setAttribute("listFournisseur", listFournisseur);
		request.setAttribute("listelv", listelv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/selectFournisseur.jsp");
		dispatcher.forward(request, response);

	}

	private void showInfoForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ElementAchats> elm = elementachatDao.selectAllElem(id);
		Achats existingVente = achatDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/achat-info.jsp");
		request.setAttribute("vente", existingVente);
		request.setAttribute("elementVente", elm);
		dispatcher.forward(request, response);

	}

	private void imprimer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		/*
		 * java.util.logging.Logger.global.info("Show edit Form"); int id =
		 * Integer.parseInt(request.getParameter("id")); List<ElementVente> elm =
		 * elementachatDao.selectAllElem(id); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("vente/imprimer.jsp");
		 * request.setAttribute("elementVente", elm); dispatcher.forward(request,
		 * response);
		 */
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ElementAchats> elm = elementachatDao.selectAllElem(id);
		Achats existingVente = achatDao.selectT(id);
		Fournisseur fournisseur = clientDao.selectT(existingVente.getId_f());
		String nomClient = fournisseur.getNomf();
		float total = 0;
		for (ElementAchats e : elm) {
			total = (float) (e.getProduit().getPrix() * e.getQuantite());

		}

		request.setAttribute("existingVente", existingVente);
		request.setAttribute("elementVente", elm);
		request.setAttribute("nomClient", nomClient);
		request.setAttribute("total", total);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/imprimer2.jsp");

		dispatcher.forward(request, response);

	}

	private void insertAchat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Vente Controller Insert Vente");

		int id_utilisateur = 1;
		String intitule = "deuxiemme Test";
//		User user = new User(1);
//		Client cl = clientDao.selectT(1);
		// int id_client = 1;
		int id_fournissuer = Integer.valueOf(request.getParameter("fournisseur"));

		Achats newAchat = new Achats(intitule, LocalDate.now(), id_fournissuer);
		achatDao.insertT(newAchat);

		Achats v = achatDao.selectLas();
//
//		for (ElementAchats elem : listelv) {
//
//			elem.setAchat(v);
//			Produit pr = produitDao.selectT(elem.getProduit().getId());
//			pr.setQuantite((pr.getQuantite() + elem.getQuantite()));
//			produitDao.updateT(pr);
//
//			elementachatDao.insertT(elem);
//
//		}
		for(int i=0; i< listelv.size();i++) {
			listelv.get(i).setAchat(v);
			Produit pr = produitDao.selectT(listelv.get(i).getProduit().getId());
			pr.setQuantite((pr.getQuantite() + listelv.get(i).getQuantite()));
			pr.setDate_exp(listProduits.get(i).getDate_exp());
			pr.setPrix(listProduits.get(i).getPrix());
			produitDao.updateT(pr);
//			LocalDate ld = listProduit.get(i).getDate_exp();
			
		}

//		ElementVente elm = new ElementVente(1,1,1);
//		elementachatDao.insertT(elm);
		// ElementVente em=elementachatDao.selectLas();

		int idElm = v.getId();

		System.out.println("id_utilisateur : " + id_utilisateur);
		System.out.println("id_client : " + id_fournissuer);
		System.out.println("intitule : " + intitule);

		//response.sendRedirect("achat?type=/imprimer&id=" + idElm + "");
		response.sendRedirect("/");

	}

	private void insertElem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Achat Controller Insert achat");
		int produit = Integer.valueOf(request.getParameter("produit"));
		int qte = Integer.valueOf(request.getParameter("qte"));
		
		LocalDate dateExpo = LocalDate.parse(request.getParameter("date_exp"));
	    float price =Float.valueOf( request.getParameter("prix"));
		 
		int id_vente = Integer.valueOf(request.getParameter("id_vente"));
		int prod = Integer.valueOf(request.getParameter("produit"));
		List<Produit> listProduit = produitDao.selectAllTs();

		if (qte >= 0) {
			for (Produit produits : listProduit) {
				if (produits.getId() == produit) {
					msg = "";
					produits.setQuantite((produits.getQuantite() + qte));
					Produit prd = produitDao.selectT(prod);
					Achats vente = achatDao.selectT(id_vente);
					String la_produit = prd.getIntitule();
					float prix = prd.getPrix();
					float prixtotal = (prix * qte);
					ElementAchats elv = new ElementAchats(vente, prd, qte);
					listelv.add(elv);
					Produit pr = new Produit(dateExpo, price);
					listProduits.add(pr);
					request.setAttribute("msg", msg);
					request.setAttribute("listelv", listelv);
					request.setAttribute("total", total);
					response.sendRedirect("achat?type=/new");
					
					break;
				}
			}
		} else {
			msg = "la quantite doit etre superieur a 0";
			request.setAttribute("msg", msg);
			request.setAttribute("listelv", listelv);
			request.setAttribute("total", total);
			response.sendRedirect("achat?type=/new");

		}

	}

	private void showNewForm2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		listelv = new ArrayList<ElementAchats>();
		listFournisseur = new ArrayList<Fournisseur>();
		List<Produit> listProduit = produitDao.selectAllTs();

		request.setAttribute("listProduit", listProduit);
		request.setAttribute("listelv", listelv);
		request.setAttribute("listClients", listFournisseur);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/achat-form.jsp");
		dispatcher.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		List<Produit> listProduit = produitDao.selectAllTs();
//			 listelv = new ArrayList<ElementVente>();
		request.setAttribute("msg", msg);

		request.setAttribute("listProduit", listProduit);
		request.setAttribute("listelv", listelv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/achat-form.jsp");
		dispatcher.forward(request, response);

	}

	private void listVente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Vente Controller List");
		List<Achats> listVente = achatDao.selectAllTs();
		java.util.logging.Logger.global.info("list vente size" + listVente.size());

		List<Integer> IdClients = new ArrayList<Integer>();
		List<Fournisseur> clientList = new ArrayList<Fournisseur>();
		List<Integer> IdUsers = new ArrayList<Integer>();
		List<User> UserList = new ArrayList<User>();

		for (Achats v : listVente) {

			IdClients.add(v.getId_f());
		}

		int j = IdClients.get(0);
		clientList.add(clientDao.selectT(j));
		for (Integer i : IdClients) {

			if (i != j) {
				clientList.add(clientDao.selectT(i));
				j = i;
			}

		}
		/*
		 * int k=IdUsers.get(0); System.out.println("id user = "+k);
		 * UserList.add(userDao.selectT(k)); for(Integer i:IdUsers) {
		 * 
		 * if(i!=k) { clientList.add(clientDao.selectT(i)); k=i; }
		 * 
		 * }
		 * 
		 * 
		 */
		request.setAttribute("listVente", listVente);
		request.setAttribute("clientList", clientList);
		// request.setAttribute("UserList", UserList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("achat/list-achat.jsp");
		dispatcher.forward(request, response);
	}

	public static List<Produit> getListProduits() {
		return listProduits;
	}

	public static void setListProduits(List<Produit> listProduits) {
		AchatsController.listProduits = listProduits;
	}

	

}
