/**
 * 
 */
package com.jsu.test.io;

import java.io.File;

import com.jsu.io.FileBuilder;
import com.jsu.io.StreamHandler;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class FileTest extends TestCase {

	public void testRead() {
		
		for(int i = 0; i < 10; i++)
		System.out.print(StreamHandler.read("E:\\eeee\\"));
			System.out.println("---------");
	}
	
	public void testWrite() {
		
		System.out.println(StreamHandler.write("E:\\eeee\\", "content"));
	}
	
	public void testGetInputFilesName() {
		
		File[] files = StreamHandler.getInputFiles(1000);
		for(int i = 0; i < files.length; i++) {
			System.out.println(files[0].getName().endsWith(".in"));
//			System.out.print(StreamHandler.read(files[i]));
			System.out.println("---------------------");
		}
	}
	
	public void testCreateGCCFile() {
		
		FileBuilder.createGCCFile("asdf", "aaaaaaaaaaaaaa");
	}
	
	public void testDeleteFile() {
		
		FileBuilder.deleteFiles("asdf");
	}
}
