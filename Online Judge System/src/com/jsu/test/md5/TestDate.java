package com.jsu.test.md5;

import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		System.out.println(((date.getTime()/1000)%86400)/3600 );
	}

}
