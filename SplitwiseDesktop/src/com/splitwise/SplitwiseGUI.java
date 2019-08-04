package com.splitwise;



import javax.swing.JLabel;
import javax.swing.JTextField;

import com.splitwise.gui.LoginPanel;
import com.splitwise.gui.MainFrame;
import com.splitwise.splitwisesdk.SplitwiseSDK;


public class SplitwiseGUI{
	private static SplitwiseGUI instance;
    private MainFrame mainFrame;
    
	SplitwiseSDK sdk;
	SplitwiseGUI() {}
	public void init() {
		
		instance = this;
		sdk = SplitwiseSDK.getInstance();
		mainFrame = MainFrame.getInstance();
		//TODO Add logic to save access token
		
		mainFrame.setVisible(true);
		showLoginPanel();
	}
	
	public void showLoginPanel() {
			mainFrame.add(LoginPanel.getInstance());
			String url = sdk.getAuthorizationURL();
			LoginPanel.getInstance().load(url);
	}
	
	public void showDashboard() {
		mainFrame.getContentPane().removeAll();
		JLabel lbl = new JLabel("oauth_access_token");
    	JTextField jtl = new JTextField();
    	jtl.setText(SplitwiseSDK.getInstance().getOauthToken());
    	
    	jtl.setSize(jtl.getPreferredSize());
    	lbl.setSize(lbl.getPreferredSize());
    	lbl.setLocation(10, 10);
    	jtl.setLocation(lbl.getPreferredSize().width + 10 + 10, 10);
    	
    	JLabel lbl2 = new JLabel("oauth_access_token_secret");
    	JTextField jtl2 = new JTextField();
    	jtl2.setText(SplitwiseSDK.getInstance().getOauthTokenSecret());
    	
    	jtl2.setSize(jtl2.getPreferredSize());
    	lbl2.setSize(lbl2.getPreferredSize());
    	lbl2.setLocation(10, 40);
    	jtl2.setLocation(lbl2.getPreferredSize().width + 10 + 10, 40);
    	mainFrame.getContentPane().setLayout(null);
    	mainFrame.getContentPane().add(lbl);
    	mainFrame.getContentPane().add(jtl);
    	mainFrame.getContentPane().add(lbl2);
    	mainFrame.getContentPane().add(jtl2);
    	mainFrame.repaint();
		
	}
	
	public static SplitwiseGUI getInstance() {
		return instance;
	}
}
