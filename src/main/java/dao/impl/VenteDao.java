package dao.impl;

import java.sql.SQLException; 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.Igenerate;
import model.Produit;
import model.Vente;
import util.HibernateUtil;

public class VenteDao implements Igenerate<Vente>{

	@Override
	public void insertT(Vente t) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(t);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Vente selectLas() {
		Transaction transaction = null;
		Vente vente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
	
			Query query = session.createQuery("from Vente order by id DESC");
			query.setMaxResults(1);
			vente = (Vente) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return vente;

	}

	@Override
	public Vente selectT(int TId) {
		Transaction transaction = null;
		Vente vente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			vente = session.get(Vente.class, TId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return vente;

	}

	
	
	
	
	@Override
	public List<Vente> selectAllTs() {
		Transaction transaction = null;
		List<Vente> vente = null;
		//try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Vente try");
			vente = session.createQuery("from Vente").getResultList();
			// commit transaction
			transaction.commit();
		/*} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Produit Catch"+vente);

			e.printStackTrace();
		}*/

		return vente;

	}

	@Override
	public boolean deleteT(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			Vente vente = session.get(Vente.class, id);
			if (vente != null) {
				session.delete(vente);
				System.out.println("vente est Suprimer");
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
	public void updateT(Vente t) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(t);
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
