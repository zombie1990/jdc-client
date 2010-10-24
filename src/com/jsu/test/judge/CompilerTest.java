/**
 * 
 */
package com.jsu.test.judge;

import com.jsu.judge.Compiler;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class CompilerTest extends TestCase {

	public void testJavac() {
		System.out.println( Compiler.compileJava("5551") );
	}
	
	public void testGCC() {
		System.out.println( Compiler.compileGCC("5552") );
	}
	
	public void testGPP() {
		System.out.println( Compiler.compileGPP("5553") );
	}
	
	public void testPascal() {
		System.out.println( Compiler.compilePascal("5554") );
	}
}
