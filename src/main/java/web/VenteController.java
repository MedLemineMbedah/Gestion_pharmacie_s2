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
import dao.impl.VenteDao;
import model.Produit;
import model.User;
import model.Vente;
import model.Clients;
import model.ElementVente;
import dao.impl.ClientDao;
import dao.impl.ElementVenteDao;

@WebServlet("/vente")
public class VenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VenteDao venteDao;
	private ProduitDaoImpl produitDao;
	private ElementVenteDao elementVenteDao;
	private ClientDao clientDao;
	private UserDao  userDao;
	private boolean qte;
	private String msg = "";
	
	private List<ElementVente> listelv = new ArrayList<ElementVente>();
	private List<Clients> listClients = new ArrayList<Clients>();
	private static List<Produit> listP = new ArrayList<Produit>();
	private int total;
	
	public void init() {
		venteDao = new VenteDao();
		produitDao = new ProduitDaoImpl();
		elementVenteDao = new ElementVenteDao();
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
			
		
           System.out.println("doget produi avant try");
           System.out.println("action "+action);
           
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/ajout":
				showNewForm2(request, response);
				break;	
			case "/insert":
				insertVente(request, response);
				break;
			case "/insertele":
				insertElem(request, response);
				break;	
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/beforInsertele":
				showNewForm3(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/info":
				showInfoForm(request, response);
				break;	
			case "/update":
				updateVente(request, response);
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
	
		private void showNewForm3(HttpServletRequest request, HttpServletResponse response) 	throws SQLException,ServletException, IOException {
	
		List<Clients> listClient = clientDao.selectAllTs();
		request.setAttribute("listClient", listClient);
		request.setAttribute("listelv", listelv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/selectClient.jsp");
		dispatcher.forward(request, response);
	
	
	}	

	
	private void imprimer(HttpServletRequest request, HttpServletResponse response) 	throws SQLException, IOException, ServletException {
	
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ElementVente> elm =   elementVenteDao.selectAllElem(id);
		Vente existingVente = venteDao.selectT(id);
		System.out.println("id client"+existingVente.getId_client());
		Clients client=clientDao.selectT(existingVente.getId_client());
		String nomClient=client.getNom();
		float total=0;
		for(ElementVente e:elm) {
			total=(float) (e.getProduit().getPrix() * e.getQuantite());
			  
		 }
		
		request.setAttribute("existingVente", existingVente);
		request.setAttribute("elementVente", elm);
		request.setAttribute("nomClient", nomClient);
		request.setAttribute("total", total);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("vente/imprimer2.jsp");

		dispatcher.forward(request, response);
	
	}


	private void listVente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Vente Controller List");
		List<Vente> listVente = venteDao.selectAllTs();
		java.util.logging.Logger.global.info("list vente size"+listVente.size());
		
		
		List<Integer> IdClients = new ArrayList<Integer>();
		List<Clients> clientList = new ArrayList<Clients>();
		List<Integer> IdUsers = new ArrayList<Integer>();
		List<User> UserList = new ArrayList<User>();
		
		
		for(Vente v:listVente) {
			
			IdClients.add(v.getId_client());
		}

		int j=IdClients.get(0);
	    clientList.add(clientDao.selectT(j));
		for(Integer i:IdClients) {
			  
			  if(i!=j) {
			    clientList.add(clientDao.selectT(i)); 
			    j=i;
			  }
			  
		 }
		
		
		msg = "";
		request.setAttribute("msg", msg);
		request.setAttribute("listVente", listVente);
		request.setAttribute("clientList", clientList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/vente-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		Date date = new Date();
		
//		 listelv = new ArrayList<ElementVente>();
		request.setAttribute("msg", msg);
		request.setAttribute("listProduit", listP);
		request.setAttribute("listelv", listelv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/vente-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void showNewForm2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,ServletException, IOException {
		java.util.logging.Logger.global.info("Show new Form");
		
		listP = new ArrayList<Produit>();
		 listelv = new ArrayList<ElementVente>();
		 listClients = new ArrayList<Clients>(); 
		 List<Produit> listProduit = produitDao.selectAllTs();
			System.out.println("List<Produit> listProduit = : "+listProduit.size());
			for (Produit produit : listProduit) {
				if(produit.getDate_exp() != null) {
				if(LocalDate.now().isAfter(produit.getDate_exp()) || produit.getQuantite() <=0) {
					continue;
				}
				
				else {
					listP.add(produit);
				}
			}
			}
			System.out.println("List<Produit> listP = : "+listP.size());
			msg = "";
			request.setAttribute("msg", msg);
		request.setAttribute("listProduit", listP);
		request.setAttribute("listelv", listelv);
		request.setAttribute("listClients", listClients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/vente-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		Vente existingVente = venteDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/vente-form.jsp");
		request.setAttribute("Vente", existingVente);
		dispatcher.forward(request, response);
	}
	private void showInfoForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		java.util.logging.Logger.global.info("Show edit Form");
		int id = Integer.parseInt(request.getParameter("id"));
		List<ElementVente> elm =   elementVenteDao.selectAllElem(id);
		Vente existingVente = venteDao.selectT(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vente/vente-info.jsp");
		
		request.setAttribute("vente", existingVente);
		request.setAttribute("elementVente", elm);
		dispatcher.forward(request, response);
	}

	
	private void insertVente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		java.util.logging.Logger.global.info("Vente Controller Insert Vente");
		int id_utilisateur = 1;
		String intitule = "deuxiemme Test";
//		User user = new User(1);
//		Client cl = clientDao.selectT(1);
	//	int id_client =  1;
		int id_client = Integer.valueOf(request.getParameter("client"));
		
		
		Vente newVente = new Vente(intitule,LocalDate.now(),id_client);
		venteDao.insertT(newVente);
		
		Vente v = venteDao.selectLas();
		
		
		for(ElementVente elem:listelv) {
			
			elem.setVente(v);
			
			Produit pr =  produitDao.selectT(elem.getProduit().getId());
			pr.setQuantite((pr.getQuantite()-elem.getQuantite()));
			pr.setPrix((float) (pr.getPrix()+(pr.getPrix()*0.1)));
			produitDao.updateT(pr);
			elementVenteDao.insertT(elem);
			
			
		}
		
//		ElementVente elm = new ElementVente(1,1,1);
//		elementVenteDao.insertT(elm);
	//	ElementVente em=elementVenteDao.selectLas();
		
		int idElm=v.getId();
		
		System.out.println("id_utilisateur : "+id_utilisateur);
		System.out.println("id_client : "+id_client);
		System.out.println("intitule : "+intitule);
		
		response.sendRedirect("vente?type=/imprimer&id="+idElm+"");
	}


	private void insertElem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Vente Controller Insert Vente");
		
		int produit = Integer.valueOf(request.getParameter("produit"));
		int qte = Integer.valueOf(request.getParameter("qte"));
		int id_vente = Integer.valueOf(request.getParameter("id_vente"));
		int prod = Integer.valueOf(request.getParameter("produit"));

		if(qte>=0) {
				for (Produit produits : listP) {
					if(produits.getId() == produit) {
						
						if(produits.getQuantite() > qte ) {
							msg = "";
						   produits.setQuantite((produits.getQuantite()-qte));
						   Produit prd = produitDao.selectT(prod);
							Vente vente = venteDao.selectT(id_vente);
							String la_produit = prd.getIntitule();
							float prix = prd.getPrix();
							float prixtotal = prix * qte;
							ElementVente elv = new ElementVente(vente, prd, qte);
							listelv.add(elv);
							
							//total
							request.setAttribute("msg", msg);
							request.setAttribute("listelv", listelv);
							request.setAttribute("total", total);
							response.sendRedirect("vente?type=/new");
						   break;
						}else {
							msg = "Quantite superieur que stock";
							request.setAttribute("msg", msg);
							request.setAttribute("listelv", listelv);
							request.setAttribute("total", total);
							response.sendRedirect("vente?type=/new");
							break;
						}
					}
				}
		}
		else {
			msg = "la quantite doit etre superieur a 0";
			request.setAttribute("msg", msg);
			request.setAttribute("listelv", listelv);
			request.setAttribute("total", total);
			response.sendRedirect("vente?type=/new");
			
		}
		
	}

	private void updateVente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
//		java.util.logging.Logger.global.info("Vente Controller Update Vente");
//		//Long id = Long.parseLong( request.getParameter("id"));
//		int id = Integer.valueOf( request.getParameter("id"));
//		LocalDate newdate = LocalDate.parse(request.getParameter("date"));
//		int id_utilisateur =  Integer.valueOf( request.getParameter("id_utilisateur"));
//		String intitule = request.getParameter("intitule");
//		int id_client =  Integer.valueOf( request.getParameter("id_client"));
//		Vente updateVente = new Vente(id,intitule,newdate,id_utilisateur,id_client);
//		
//		venteDao.updateT(updateVente);
		response.sendRedirect("list");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		java.util.logging.Logger.global.info("Vente Controller Delete Vente");

		int id = Integer.parseInt(request.getParameter("id"));
		venteDao.deleteT(id);
		response.sendRedirect("list");
	}
	public VenteDao getVenteDao() {
		return venteDao;
	}
	public void setVenteDao(VenteDao venteDao) {
		this.venteDao = venteDao;
	}
	public ProduitDaoImpl getProduitDao() {
		return produitDao;
	}
	public void setProduitDao(ProduitDaoImpl produitDao) {
		this.produitDao = produitDao;
	}
	public ElementVenteDao getElementVenteDao() {
		return elementVenteDao;
	}
	public void setElementVenteDao(ElementVenteDao elementVenteDao) {
		this.elementVenteDao = elementVenteDao;
	}
	public List<ElementVente> getListelv() {
		return listelv;
	}
	public void setListelv(List<ElementVente> listelv) {
		this.listelv = listelv;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isQte() {
		return qte;
	}
	public void setQte(boolean qte) {
		this.qte = qte;
	}
	public List<Produit> getListP() {
		return listP;
	}
	public void setListP(List<Produit> listP) {
		this.listP = listP;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
