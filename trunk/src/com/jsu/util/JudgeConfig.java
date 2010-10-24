/**
 * 
 */
package com.jsu.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-1-26
 */
public class JudgeConfig {

	private final static Logger log = Logger.getLogger(JudgeConfig.class);
	private static final String PATH = "/judgeconfig.properties";
	private static Properties properties = null;
	
	public static String getValue(String key) {
		/**
		 * get value matches the key.
		 */
		load();
		return properties.getProperty(key);
	}
	
	private static void load() {
		properties = new Properties();
		try {
			InputStream is = JudgeConfig.class.getResourceAsStream(PATH);
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("can not load judgrconfig.properties");
		}
	}
}
