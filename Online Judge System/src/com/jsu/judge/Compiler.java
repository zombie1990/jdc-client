/**
 * 
 */
package com.jsu.judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.jsu.util.JudgeConfig;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-2-7
 */
public class Compiler {

	private final static Logger log = Logger.getLogger(Compiler.class);
	private static String JUDGE_BASE = JudgeConfig.getValue("JUDGE_BASE");
	private static String gccCompiler = JUDGE_BASE + "bin\\GNU\\bin\\gcc.exe -fno-asm -s -w " + JUDGE_BASE + "temp\\";
	private static String gppCompiler = JUDGE_BASE + "bin\\GNU\\bin\\g++.exe -fno-asm -s -w " + JUDGE_BASE + "temp\\";
	private static String javaCompiler = JUDGE_BASE + "bin\\SUN\\bin\\javac.exe " + JUDGE_BASE + "temp\\";
	private static String pascalCompiler = JUDGE_BASE + "bin\\PASCAL\\fpc.exe -Sg " + JUDGE_BASE + "temp\\";
	
	public static String compileGCC(String runId) {
		/**
		 * return "success" if compile the C code success,
		 * else, return the error-information as a String.
		 */
		return compile(runId, 0);
	}
	
	public static String compileGPP(String runId) {
		/**
		 * return "success" if compile the C++ code success,
		 * else, return the error-information as a String.
		 */
		return compile(runId, 1);
	}
	
	public static String compileJava(String runId) {
		/**
		 * return "success" if compile the Java code success,
		 * else, return the error-information as a String.
		 */
		return compile(runId, 2);
	}
	
	public static String compilePascal(String runId) {
		/**
		 * return "success" if compile the Pascal code success,
		 * else, return the error-information as a String.
		 */
		return compile(runId, 3);
	}
	
	private static String compile(String runId, int language) {
		/**
		 * compiling source-code with GCC, G++, SunJava, FreePascal depend on the switch languages.
		 * languages of compiler:
		 *          		  0 : GNU gcc.exe
		 *          		  1 : GNU g++.exe
		 *          		  2 : SUN javac.exe
		 *          		  3 : FreePascal fpc.exe
		 */
		String command = null;
		switch (language) {
			case 0 : 
				command = gccCompiler + runId + "\\Main.c -o " + JUDGE_BASE + "temp\\" + runId + "\\Main.exe";
				break;
			
			case 1 : 
				command = gppCompiler + runId + "\\Main.cpp -o " + JUDGE_BASE + "temp\\" + runId + "\\Main.exe";
				break;
			
			case 2 : 
				command = javaCompiler + runId + "\\Main.java";
				break;
			
			case 3 : 
				command = pascalCompiler + runId + "\\Main.pas " + JUDGE_BASE + "temp\\" + runId + "\\Main";
			
			default : break;
		}
		
		StringBuilder error = new StringBuilder();
		try {
			Process process;
			process = Runtime.getRuntime().exec(command);
			BufferedReader in =new BufferedReader( new InputStreamReader( process.getErrorStream() ) );
			
			String line = new String();
			while ( (line = in.readLine()) != null ) {
				error.append( line.trim() );
				error.append('\n');
			}
			in.close();
			
			process.waitFor();
			if ( process.exitValue() == 0 ) {
				log.info("---- compiled code success ----");
				return "success";
			}
			else
				log.warn("---- compiling code failed ----");
		} catch (IOException ioe) {
			log.error(ioe.getMessage());
		} catch (InterruptedException ie) {
			log.error(ie.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		} 
		return error.toString();

	}

}
