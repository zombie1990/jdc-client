/**
 * 
 */
package com.jsu.util;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-2-8
 */
public class JudgeQueue {

	/**
	 * queues for different compiler.
	 */
	private static ConcurrentLinkedQueue<String> QueueGCC = new ConcurrentLinkedQueue<String>();
	private static ConcurrentLinkedQueue<String> QueueGPP = new ConcurrentLinkedQueue<String>();
	private static ConcurrentLinkedQueue<String> QueueJava = new ConcurrentLinkedQueue<String>();
	private static ConcurrentLinkedQueue<String> QueuePascal = new ConcurrentLinkedQueue<String>();
	
	/****************  Queue for GCC compiler  *********************/
	public static boolean addGCC(String runId) {
		/**
		 * Add a GCC runId.
		 */
		try {
			QueueGCC.add(runId);
			return true;
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			return false;
		}
	}
	public static String pollGCC() {
		/**
		 * Take a GCC runId.
		 */
		return QueueGCC.poll();
	}
	public static boolean isGCCEmpty() {
		return QueueGCC.isEmpty();
	}
	
	/****************  Queue for G++ compiler  *********************/
	public static boolean addGPP(String runId) {
		/**
		 * Add a G++ runId.
		 */
		try {
			QueueGPP.add(runId);
			return true;
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			return false;
		}
	}
	public static String pollGPP() {
		/**
		 * Take a G++ runId.
		 */
		return QueueGPP.poll();
	}
	public static boolean isGPPEmpty() {
		return QueueGPP.isEmpty();
	}
	
	/****************  Queue for Java compiler  *********************/
	public static boolean addJava(String runId) {
		/**
		 * Add a G++ runId.
		 */
		try {
			QueueJava.add(runId);
			return true;
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			return false;
		}
	}
	public static String pollJava() {
		/**
		 * Take a G++ runId.
		 */
		return QueueJava.poll();
	}
	public static boolean isJavaEmpty() {
		return QueueJava.isEmpty();
	}
	
	/****************  Queue for Pascal compiler  *********************/
	public static boolean addPascal(String runId) {
		/**
		 * Add a G++ runId.
		 */
		try {
			QueuePascal.add(runId);
			return true;
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			return false;
		}
	}
	public static String pollPascal() {
		/**
		 * Take a G++ runId.
		 */
		return QueuePascal.poll();
	}
	public static boolean isPascalEmpty() {
		return QueuePascal.isEmpty();
	}
}
