package dao.impl;

import java.sql.SQLException; 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Igenerate;
import model.Clients;
import util.HibernateUtil;

public class ClientDao implements Igenerate<Clients>{

	public ClientDao() {
		
	}
	
	@Override
	public void insertT(Clients client) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(client);
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
	public Clients selectT(int clientId) {
		Transaction transaction = null;
		Clients client = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			client = session.get(Clients.class, clientId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return client;

	}

	@Override
	public List<Clients> selectAllTs() {
		Transaction transaction = null;
		List<Clients> client = null;
//		try () {
			// start a transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Achat try");
			client = session.createQuery("from Clients").getResultList();
			//List<User> result = session.createQuery("from User", User.class).getResultList();
			// commit transaction
			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
		java.util.logging.Logger.global.info("ToDoDAOIMPL Select All Achat Catch"+client);

		return client;

	}

	@Override
	public boolean deleteT(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			Clients client = session.get(Clients.class, id);
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
	public void updateT(Clients t) throws SQLException {
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
