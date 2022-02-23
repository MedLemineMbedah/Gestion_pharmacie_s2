package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Igenerate;
import model.Clients;
import model.Fournisseur;
import util.HibernateUtil;

public class FournisseurDao implements Igenerate<Fournisseur>{

	@Override
	public void insertT(Fournisseur t) throws SQLException {
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

	@Override
	public Fournisseur selectT(int TId) {
		Transaction transaction = null;
		Fournisseur fournisseur = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			fournisseur = session.get(Fournisseur.class, TId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return fournisseur;

	}

	@Override
	public List<Fournisseur> selectAllTs() {
		Transaction transaction = null;
		List<Fournisseur> fournisseur = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All fournisseur try");
			fournisseur = session.createQuery("from Fournisseur").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		java.util.logging.Logger.global.info("ToDoDAOIMPL Select All fournisseur Catch"+fournisseur);

		return fournisseur;

	}

	@Override
	public boolean deleteT(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			Fournisseur client = session.get(Fournisseur.class, id);
			if (client != null) {
				session.delete(client);
				session.getTransaction().commit();
				System.out.println("Client est Suprimer");
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
	public void updateT(Fournisseur t) throws SQLException {
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
