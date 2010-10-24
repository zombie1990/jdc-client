/**
 * 
 */
package com.jsu.test.judge;

import java.io.File;

import com.jsu.judge.JavaRunner;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class JavaRunnerTest extends TestCase {

	public void testJavaRun() {
		
		File input = new File("F:\\inputs\\1.txt");
		File output = new File("F:\\outputs\\1.txt");
		
		int i = JavaRunner.run("5551", 1000, 32767, input, output);
		System.out.println(i%100000);
		System.out.println(i/100000);
	}
}
