/**
 * 
 */
package com.jsu.test.judge;

import java.io.File;

import com.jsu.judge.Runner;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class RunnerTest extends TestCase {

	public void testRunGCC() {

		File input = new File("F:\\JudgeBase\\data\\1002\\inputs\\data1.in");
		File output = new File("F:\\JudgeBase\\data\\1002\\outputs\\data1.out");
//		System.out.println(StreamHandler.read(output));
		int i = Runner.run("5553", 1000, 32767000, input, output);
		System.out.println(Runner.timeWaste);
		System.out.println(Runner.memoryWaste >> 10);
		System.out.println(i);
	}
}
