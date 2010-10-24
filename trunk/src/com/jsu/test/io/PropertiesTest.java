/**
 * 
 */
package com.jsu.test.io;

import com.jsu.io.StreamHandler;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class PropertiesTest extends TestCase {

	public void testProperties() {
		
		String[] ss = StreamHandler.getInputFilesName(1000);
		for(int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
