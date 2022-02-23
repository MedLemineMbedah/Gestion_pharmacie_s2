package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.Igenerate;
import model.ElementAchats;
import model.ElementVente;
import model.Vente;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.Igenerate;
import util.HibernateUtil;

public class ElementAchatDao implements Igenerate<ElementAchats>{

	@Override
	public void insertT(ElementAchats t) throws SQLException {
		Transaction transaction = null;
//		try () {
		Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(t);
			// commit transaction
			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
	}

	@Override
	public ElementAchats selectT(int TId) {
		Transaction transaction = null;
		ElementAchats ElementVente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			ElementVente = session.get(ElementAchats.class, TId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return ElementVente;


	}

	@Override
	public List<ElementAchats> selectAllTs() {
		Transaction transaction = null;
		List<ElementAchats> ElementVente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All vente try");
			ElementVente = session.createQuery("from ElementAchats").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		java.util.logging.Logger.global.info("ToDoDAOIMPL Select All vente Catch"+ElementVente);

		return ElementVente;

	}
	
	public List<ElementAchats> selectAllElem(int id) {
		Transaction transaction = null;
		List<ElementAchats> ElementVente = null;
//		try () {
			// start a transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get an user object
			java.util.logging.Logger.global.info("ToDoDAOIMPL Select All vente try");
			ElementVente = session.createQuery("from ElementAchats where id_achat = "+id).getResultList();

			// commit transaction
			transaction.commit();

		return ElementVente;

	}

	@Override
	public boolean deleteT(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			ElementAchats vente = session.get(ElementAchats.class, id);
			if (vente != null) {
				session.delete(vente);
				System.out.println("ElementAchats est Suprimer");
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
	public void updateT(ElementAchats t) throws SQLException {
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
