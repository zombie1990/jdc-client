/**
 * 
 */
package com.jsu.hibernate.domains;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.jsu.test.persistence.GeneralDAOTest;

/**
 * @author Administrator
 *
 */
public class Tools4hbm2ddl {

	private final static Logger log = Logger.getLogger(GeneralDAOTest.class);
	/**
	 * Export *.hbm.xml 2 database-schema
	 */
	public static void main(String[] args) {
		
		log.info("---- prepare for schema export... ----");
		try {
			Configuration cfg = new Configuration().configure();
			SchemaExport se = new SchemaExport(cfg);
			se.create(true, true);
			log.info("---- export schema successful! ----");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("---- export schema unsuccessful! ----");
		}
		
	}

}
