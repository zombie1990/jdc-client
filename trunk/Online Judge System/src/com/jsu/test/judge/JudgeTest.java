/**
 * 
 */
package com.jsu.test.judge;


import com.jsu.judge.Judger;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class JudgeTest extends TestCase {

	public void testJudge() {
//		4028b5c1273b458f01273b470ad20003   OK
//		4028b5c1273b4d8d01273b4de14f0003   BAD
		Judger.judge("4028b5c1273b458f01273b470ad20003", 1);
		
//		try {
//			throw new NullPointerException();
//		} catch(Exception e) {
//			System.out.println(e.toString()+e.getMessage());
//		}
	}
}
