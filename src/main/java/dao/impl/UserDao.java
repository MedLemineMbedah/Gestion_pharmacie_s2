package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.Igenerate;


import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import java.math.BigInteger; 
import java.security.MessageDigest;

import model.User;
import model.Vente;


public class UserDao implements Igenerate<User>{
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {

		Transaction transaction = null;
		User user = null;
		java.util.logging.Logger.global.info("fonction validate");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			java.util.logging.Logger.global.info("fonction validate dans try");
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();
			java.util.logging.Logger.global.info("utilisateur :"+user);
			MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.update(password.getBytes());
	        BigInteger hash = new BigInteger(1, md5.digest());
	        String passwords = hash.toString(16);
			if(user != null && user.getPassword().equals(passwords)) {
				java.util.logging.Logger.global.info("fonction validate try si tous est correct");

				return true;
			}
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			java.util.logging.Logger.global.info("fonction validate dans catch");
			if (transaction != null) {
				transaction.rollback();
				java.util.logging.Logger.global.info("fonction validate dans catch if statement");

			}
			e.printStackTrace();
		}
		java.util.logging.Logger.global.info("sortie function validate");

		return false;
	}

	@Override
	public void insertT(User t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectT(int TId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllTs() {
		Transaction transaction = null;
		List<User> u = null;
		//try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All User try");
			u = session.createQuery("from User").getResultList();
			// commit transaction
			transaction.commit();
		/*} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Produit Catch"+vente);

			e.printStackTrace();
		}*/

		return u;

	}
	@Override
	public boolean deleteT(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateT(User t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	


	

	
}
