package com.huko.text.adventure.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.huko.text.adventure.game.Enemy;
import com.huko.text.adventure.game.GameObject;
import com.huko.text.adventure.game.Map;
import com.huko.text.adventure.game.Player;
import com.huko.text.adventure.game.inventory.Inventory;
import com.huko.text.adventure.interpreter.CommandInterpreter;

public class GameWindow extends JFrame implements KeyListener {

	// This is info Panel
	private StatCanvas infoPanel;

	// The exact game screen where the World is drawn
	private WorldCanvas canvas;

	// The player's object
	public static Player hero;

	public static Inventory inventory;

	// All objects that can be currently drawn
	public static ArrayList<GameObject> visibleObjects;

	// All objects that are in the game
	public static ArrayList<GameObject> allObjects;

	public static Map[][] map = new Map[16][16];

	// Command object that is receiving operations
	public static CommandInterpreter cmd;

	public GameWindow() {
		initialize();
		setTitle("Game Window");
		setSize(600, 480);

		infoPanel = new StatCanvas();
		canvas = new WorldCanvas();

		infoPanel.setPreferredSize(new Dimension(220, 150));
		add(infoPanel, BorderLayout.WEST);
		add(canvas, BorderLayout.CENTER);
	}

	/**
	 * Initialize all mouse and keyboard listeners Create arrays and objects
	 * that will be needed in the game
	 */
	private void initialize() {
		// Adds key listener to GameWindow object
		addKeyListener(this);

		for (int i = 0; i <= 15; i++) {
			for (int j = 0; j <= 15; j++) {
				map[i][j] = new Map();
			}
		}

		cmd = new CommandInterpreter();
		allObjects = new ArrayList<GameObject>();
		visibleObjects = new ArrayList<GameObject>();

		hero = new Player(0, 0, 100);
		inventory = new Inventory();

		visibleObjects.add(new Enemy(5, 5, 100, 1));
		visibleObjects.add(new Enemy(1, 8, 100, 1));
		visibleObjects.add(new Enemy(7, 2, 100, 1));
	}

	/**
	 * Process keyboard events on keyPressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			hero.move(-1, 0);
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			hero.move(1, 0);
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			hero.move(0, -1);
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			hero.move(0, 1);
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			inventory.addBag();
			infoPanel.draw();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
