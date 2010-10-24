/**
 * 
 */
package com.jsu.util;

/**
 * @author Administrator
 *
 */
public class LongConverter {

	
	public static long strToLong(String s) {
		byte[] b = s.getBytes();
		int j = s.length() -1;
		long number = 0;
		for(int i = 0; i<s.length(); i++) {
			Byte sub = b[i];
			long bit = sub.longValue() - 48;
			number += bit*rN(j);
			j = j - 1;
		}
		return number;
	}
	
	private static long rN(int n) {
		long R = 1;
		for(int i = 1; i <= n; i++)
			R = R*10;
		return R;
	}
}
