package com.splitwise.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static MainFrame instance;
	
	private MainFrame() {
		configureComponents();
		initComponents();
		computeSize();
		computePlacement();
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	private void initComponents() {}
	
	private void configureComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void computeSize() {
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
	}
	private void computePlacement() {
		
	}
}
