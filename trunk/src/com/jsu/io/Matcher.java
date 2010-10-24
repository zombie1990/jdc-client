/**
 * 
 */
package com.jsu.io;

import java.io.File;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-2-4
 */
public class Matcher {

	public static final int Judging = 0;
	public static final int Accepted = 1;
	public static final int Presentation_Error = 2;
	public static final int Time_Limit_Exceeded = 3;
	public static final int Memory_Limit_Exceeded = 4;
	public static final int Wrong_Answer = 5;
	public static final int Compilation_Error = 6;
	public static final int Runtime_Error = 7;
	public static final int System_Error = 8;
	public static final int NO_TESTCASE = 9;
	
	public static int matchFile(File stdFile, String userFileName) {
		/**
		 * match userFile with stdFile by fileName.
		 */
		String std = StreamHandler.read(stdFile);
		String user = StreamHandler.read(userFileName);
		if ( std.equals(user) )
			return Accepted;
		if ( std.replace('\n', ' ').trim().equals(user.replace('\n', ' ').trim()) )
			return Presentation_Error;
		return Wrong_Answer;
	}
	
	public static int matchFile(File stdFile, File userFile) {
		/**
		 * match userFile with stdFile by file.
		 */
		String std = StreamHandler.read(stdFile);
		String user = StreamHandler.read(userFile);
		if ( std.equals(user) )
			return Accepted;
		if ( std.replace('\n', ' ').trim().equals(user.replace('\n', ' ').trim()) )
			return Presentation_Error;
		return Wrong_Answer;
	}
	
	public static int matchDirectly(File stdFile, String userOutput) {
		/**
		 * directly match user's output with stdFile.
		 */
		String std = StreamHandler.read(stdFile);
		if ( std.equals(userOutput) )
			return Accepted;
		if ( std.replace('\n', ' ').trim().equals(userOutput.replace('\n', ' ').trim()) )
			return Presentation_Error;
		return Wrong_Answer;
	}
}
