/**
 * 
 */
package com.jsu.judge;

import com.jsu.util.JudgeQueue;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-2-8
 */
public class JavaThread extends Thread {

	public void run() {
		while (true) {
			String runId = JudgeQueue.pollJava();
			if(runId == null) {
				try {
					Thread.sleep(1000);
				} catch(Exception e) {
				}
			} else {
				Judger.judge(runId, 2);
			}
		}
	}
}
