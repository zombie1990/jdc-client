/**
 * 
 */
package com.jsu.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class OnlineUserList {

	private static List<String> list = Collections.synchronizedList(new LinkedList<String>());
	
	public static boolean addUser(String username) {
		if(list.indexOf(username) == -1) {
			list.add(username);
			return true;
		}
		return false;
	}
	
	public static boolean removeUser(String username) {
		if(list.remove(username)) {
			return true;
		}
		return false;
	}
	
	public static int userSize() {
		return list.size();
	}
	
	public static List<String> list() {
		return list;
	}
}
