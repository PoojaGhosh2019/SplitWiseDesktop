/**
 * Splitwise.java : Entry class to initialize User Interface

 * @version		0.1
 * @since   	2019-02-14
 */
package com.splitwise;

public class Splitwise {
	static SplitwiseGUI gui;
	public static void main(String[] arg) {
		System.out.println("Ok");
		gui = new SplitwiseGUI();
		gui.init();
	}
}
