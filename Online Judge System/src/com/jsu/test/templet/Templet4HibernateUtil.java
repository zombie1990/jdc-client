package com.jsu.test.templet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Templet4HibernateUtil {

    private static SessionFactory sessionFactory;

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
    	return sessionFactory.openSession();
    }
    
    public static void closeSession(Session session) {
    	if (session != null) {
    		if (session.isOpen()) {
    			session.close();
    		}
    	}
    }
}
