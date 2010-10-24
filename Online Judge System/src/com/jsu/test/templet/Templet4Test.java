package com.jsu.test.templet;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import junit.framework.TestCase;


public class Templet4Test extends TestCase {
	private final static Logger log = Logger.getLogger(Templet4Test.class);
	public void testSave() {
		
		Session session = null;
		try {
				session = Templet4HibernateUtil.getSession();
				session.beginTransaction();
	
				//@Todo some in next line

				log.info("saved successful!");
				
				session.getTransaction().commit();
		} catch(HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	

	public void testLoad() {
		
		Session session = null;
		try {
				session = Templet4HibernateUtil.getSession();
				session.beginTransaction();
	
				//@Todo some in next line

				log.info("load successful!");
				
				session.getTransaction().commit();
		} catch(HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void testDelete() {
		
		Session session = null;
		try {
				session = Templet4HibernateUtil.getSession();
				session.beginTransaction();
	
				//@Todo some in next line

				log.info("delete successful!");
				
				session.getTransaction().commit();
		} catch(HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
