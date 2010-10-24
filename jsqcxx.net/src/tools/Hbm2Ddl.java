package tools;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author xiyu
 *
 */
public class Hbm2Ddl {

	public static void main(String[] args) {

		try {
			Configuration cfg = new Configuration().configure();
			SchemaExport se = new SchemaExport(cfg);
			se.create(true, true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
