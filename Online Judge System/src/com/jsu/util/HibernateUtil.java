/**
 * 
 */
package com.jsu.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-1-26
 */
public class HibernateUtil {

	private static final ThreadLocal<Session> threadLocalS = new ThreadLocal<Session>();
	private static final ThreadLocal<Transaction> threadLocalT = new ThreadLocal<Transaction>();
    private static SessionFactory sessionFactory;
    
    private HibernateUtil() {}
    
    /**
     * Create the SessionFactory from <file>hibernate.cfg.xml</file>.
     * Be sure that the xml file in the rootpath, that is to say : src/hibernate.cfg.xml .
     */
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the current <code>SessionFactory</code>.
     * 
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

/*********************methods for Session and Transaction in a ThreadSafe Mode**************************/
	
	/**
	 * Get a Session from the <code>ThreadLocal</code>. And if the current 
	 * session is unavailable, open a new session from the current SessionFactory.
	 * 
	 * @return Session
	 */
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
    
	/**
	 *  Get a Session from the <code>ThreadLocal</code>, and clear the 
	 *  ThreadLocal. Then close this Session.
	 */
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

	/**
	 *  Begin a Transaction from the current Session, and
	 *  set this Transaction into the <code>ThreadLocal</code>.
	 */
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
	
	/**
	 * Get a Transaction from the <code>ThreadLocal</code> and
	 * if the Transaction have not been committed without rolledback, 
	 * commit it again.
	 */
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
	
	/**
	 * Get a Transaction from the <code>ThreadLocal</code> and
	 * if the Transaction have not been committed without rolledback, 
	 * rollback it again.
	 */
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
