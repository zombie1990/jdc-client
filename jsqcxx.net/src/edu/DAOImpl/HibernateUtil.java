package edu.DAOImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author xiyu
 *
 */
public class HibernateUtil {

	private static final ThreadLocal<Session> threadLocalS = new ThreadLocal<Session>();
	private static final ThreadLocal<Transaction> threadLocalT = new ThreadLocal<Transaction>();
    private static SessionFactory sessionFactory;
    
    private HibernateUtil() {}
    
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
	public static Session getSession() {
		Session session = (Session)threadLocalS.get();
		
		try {
			if((session == null) || !session.isOpen()) {
				session = getSessionFactory().openSession();
				threadLocalS.set(session);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void closeSession() {
		Session session = (Session)threadLocalS.get();
		threadLocalS.set(null);
		
		try {
			if(session != null && session.isOpen()) {
				session.close();
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static void beginTransaction() {
		Transaction tx = (Transaction)threadLocalT.get();
		
		try {
			if(tx == null) {
				tx = getSession().beginTransaction();
				threadLocalT.set(tx);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static void commitTransaction() {
		Transaction tx = (Transaction)threadLocalT.get();
		
		try {
			if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.commit();
				threadLocalT.set(null);
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollbackTransaction() {
		Transaction tx = (Transaction)threadLocalT.get();
		
		try {
			threadLocalT.set(null);
			if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.rollback();
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
}
