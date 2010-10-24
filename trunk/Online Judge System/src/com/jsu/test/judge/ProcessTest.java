/**
 * 
 */
package com.jsu.test.judge;

import com.jsu.util.JudgeConfig;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class ProcessTest extends TestCase {
	private static String JUDGE_BASE = JudgeConfig.getValue("JUDGE_BASE");
	//private static String gccCompiler = JUDGE_BASE + "bin\\GNU\\bin\\gcc.exe -fno-asm -s -w " + JUDGE_BASE + "temp\\";
	//private static String gppCompiler = JUDGE_BASE + "bin\\GNU\\bin\\g++.exe -fno-asm -s -w " + JUDGE_BASE + "temp\\";
	//private static String javaCompiler = JUDGE_BASE + "bin\\SUN\\bin\\javac.exe " + JUDGE_BASE + "temp\\";
	private static String javaRunner = JUDGE_BASE + "bin\\SUN\\bin\\java.exe -classpath " + JUDGE_BASE + "temp\\";
	//private static String pascalCompiler = JUDGE_BASE + "bin\\PASCAL\\fpc.exe -Sg " + JUDGE_BASE + "temp\\";
	public void testProcess() {
		
		
		try {
			Process process;
			Runtime  runtime = Runtime.getRuntime();
			long start = runtime.freeMemory();
			//System.out.println(start);
			//process = runtime.exec(gccCompiler + "5552" + "\\Main.exe");
			process = runtime.exec(javaRunner + "5551" + "\\Main");
			process.waitFor();
			//System.out.println(runtime.maxMemory()/1024);
			//System.out.println(runtime.totalMemory()/1024);
			long end = runtime.freeMemory();
			System.out.println(start-end);
			System.out.println(process.exitValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
