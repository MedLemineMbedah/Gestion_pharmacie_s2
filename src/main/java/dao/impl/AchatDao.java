package dao.impl;

import java.sql.SQLException; 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.Igenerate;
import model.Achats;
import model.Produit;
import model.Vente;
import util.HibernateUtil;

public class AchatDao implements Igenerate<Achats>{

	@Override
	public void insertT(Achats t) throws SQLException {
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
	
	public Achats selectLas() {
		Transaction transaction = null;
		Achats vente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
	
			Query query = session.createQuery("from Achats order by id DESC");
			query.setMaxResults(1);
			vente = (Achats) query.uniqueResult();
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
	public Achats selectT(int TId) {
		Transaction transaction = null;
		Achats vente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			vente = session.get(Achats.class, TId);
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
	public List<Achats> selectAllTs() {
		Transaction transaction = null;
		List<Achats> vente = null;
		//try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Achats try");
			vente = session.createQuery("from Achats").getResultList();
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

		
			Achats vente = session.get(Achats.class, id);
			if (vente != null) {
				session.delete(vente);
				System.out.println("Achats est Suprimer");
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
	public void updateT(Achats t) throws SQLException {
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
