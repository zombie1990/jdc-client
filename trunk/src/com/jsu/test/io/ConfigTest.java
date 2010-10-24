/**
 * 
 */
package com.jsu.test.io;

import com.jsu.util.JudgeConfig;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class ConfigTest extends TestCase {

	public void testConfig() {
		
		String str1 = JudgeConfig.getValue("JUDGE_BASE");
		System.out.println(str1);
	}

}
