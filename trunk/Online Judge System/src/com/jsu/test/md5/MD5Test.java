/**
 * 
 */
package com.jsu.test.md5;


import com.jsu.util.MD5;

/**
 * @author Administrator
 *
 */
public class MD5Test {

	/**
	 * @param strings
	 */
	public static void main(String... strings) {
		// TODO Auto-generated method stub
		String str;
		str = "root";
//		File file = new File("F:\\inputs\\1.txt");
//		String str2 = StreamHandler.read(file);
		
		// Static method 4 get a string of it MD5
		System.out.println(MD5.getMD5(str));
//		System.out.println(str2);
//		System.out.println(MD5.getMD5(str2));
//		System.out.println(MD5.getMD5(str2));
//		Character c = '\n';
//		String s = c.toString();
//		System.out.println(s);
		
	}

}
