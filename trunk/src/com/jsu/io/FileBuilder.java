/**
 * 
 */
package com.jsu.io;

import java.io.File;

import org.apache.log4j.Logger;

import com.jsu.util.JudgeConfig;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-2-4
 */
public class FileBuilder {

	private final static Logger log = Logger.getLogger(FileBuilder.class);
	
	public static boolean createGCCFile(String runId, String code) {
		/**
		 * create a code file for compiler:GCC.exe.
		 */
		File dir = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId);
		File file = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId + "\\Main.c");
		try {
			dir.mkdirs();
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return StreamHandler.write(file, code);
	}
	
	public static boolean createGPPFile(String runId, String code) {
		/**
		 * create a code file for compiler:G++.exe.
		 */
		File dir = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId);
		File file = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId + "\\Main.cpp");
		try {
			dir.mkdirs();
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return StreamHandler.write(file, code);
	}
	
	public static boolean createJavaFile(String runId, String code) {
		/**
		 * create a code file for compiler:JAVAC.exe.
		 */
		File dir = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId);
		File file = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId + "\\Main.java");
		try {
			dir.mkdirs();
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return StreamHandler.write(file, code);
	}
	
	public static boolean createPascalFile(String runId, String code) {
		/**
		 * create a code file for compiler:fpc.exe.
		 */
		File dir = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId);
		File file = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId, "\\Main.pas");
		try {
			dir.mkdirs();
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return StreamHandler.write(file, code);
	}
	
	public static void deleteFiles(String runId) {
		/**
		 * delete all files in the judge temp by run's id.
		 */
		try {
			File directory = new File(JudgeConfig.getValue("JUDGE_BASE") +"temp\\" + runId);
			File[] files = directory.listFiles();
			for (int i = 0; i < files.length; i++)
				files[i].delete();
			directory.delete();
		} catch (SecurityException se) {
			log.warn("---- catch a SecurityException, delete files failed ----");
		}
	}
	
	
}
