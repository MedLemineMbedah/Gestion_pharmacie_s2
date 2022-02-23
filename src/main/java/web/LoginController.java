package web;

import java.io.IOException; 
import java.lang.System.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.security.*;
import dao.impl.UserDao;
import model.User;
import util.HibernateUtil;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao loginDao;

	public void init() {
		loginDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessiona=request.getSession(false); 
		if((String)sessiona.getAttribute("nom")!=null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		java.util.logging.Logger.global.info("ici Ahmed");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		if (loginDao.validate(username, password)) {
			Transaction transaction = null;
			User user = null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();
			
			
			java.util.logging.Logger.global.info("valide password");
			HttpSession sessiona=request.getSession();  
			sessiona.setAttribute("nom",username);
			sessiona.setAttribute("type",user.getType());
			sessiona.setAttribute("nom", user.getNom());
			sessiona.setAttribute("prenom", user.getPrenom());
//			String type="";
//			sessiona.setAttribute("type",type );
//			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
//	@Path("/delete")
//	private void supprimer(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		String id = request.getParameter("id");
//		int id1=0;
//		try {
//			 id1=Integer.parseInt(id);
//		}
//		catch(NumberFormatException ex) {
//			ex.printStackTrace();
//		}
//		
//
//		if (loginDao.deleteT(id1)) {
//			java.util.logging.Logger.global.info("valide password");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("delete-success.jsp");
//			dispatcher.forward(request, response);
//		}else {
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
//	}
}
