package web;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDao;
import model.User;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
			register(request, response);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
		}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NoSuchAlgorithmException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String username = request.getParameter("username");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((request.getParameter("password")).getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());
        String password = hash.toString(16);
//        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
         

        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }
}
