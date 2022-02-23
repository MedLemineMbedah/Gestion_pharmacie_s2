package dao.impl;




import java.sql.SQLException;   
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Igenerate;
import model.Produit;

import util.HibernateUtil;
 

public class ProduitDaoImpl implements Igenerate<Produit> {

	public ProduitDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insertT(Produit produit) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(produit);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public Produit selectT(int produitId) {
		Transaction transaction = null;
		Produit produit = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			produit = session.get(Produit.class, produitId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return produit;
	}
	@Override
	public List<Produit> selectAllTs() {
	
		Transaction transaction = null;
		List<Produit> produit = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Produit try");
			produit = session.createQuery("from Produit").getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Produit Catch"+produit);

			e.printStackTrace();
		}

		return produit;
	}
	@Override
	public boolean deleteT(int id) throws SQLException {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			Produit produit = session.get(Produit.class, id);
			if (produit != null) {
				session.delete(produit);
				session.getTransaction().commit();
				System.out.println("Medicament est Suprimer");
				return true;
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void updateT(Produit produit) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(produit);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}


	
}
