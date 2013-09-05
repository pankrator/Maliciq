package com.huko.text.adventure.launch;

import javax.swing.JFrame;

import com.huko.text.adventure.window.GameWindow;

/**
 * This the Entry point for the Game
 * Initialize the GameWindow
 * @author NIST
 *
 */
public class LaunchPoint {

	public static void main(String[] args) {
		
		GameWindow gw = new GameWindow();
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setResizable(false);
		gw.setVisible(true);
		
//		gw.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
	}

}
