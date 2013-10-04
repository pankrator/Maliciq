package com.huko.adventure.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.huko.adventure.game.algo.NodeMap;
import com.huko.adventure.game.effects.Effect;
import com.huko.adventure.game.effects.EffectsManager;
import com.huko.adventure.game.entities.AbstractPlayer;
import com.huko.adventure.game.entities.Block;
import com.huko.adventure.game.entities.GameObject;
import com.huko.adventure.game.entities.SmartEnemy;
import com.huko.adventure.game.inventory.Inventory;
import com.huko.adventure.game.logic.KeyBoardLogic;
import com.huko.adventure.game.logic.MouseLogic;

public class GameWindow extends JFrame {

    // This is info Panel
    private StatCanvas infoPanel;

    // The exact game screen where the World is drawn
    private WorldCanvas canvas;

    // The player's object
    public static AbstractPlayer hero;

    public static Inventory inventory;

    // All objects that can be currently drawn
    public static List<GameObject> visibleObjects;

    // All objects that are in the game
    public static List<GameObject> allObjects;

    // Map representing rectangles and used to detect movements
    public static NodeMap nodeMap = new NodeMap(35, 35, 1);

    // Effect list manager
    public static EffectsManager explosionManager = EffectsManager.getInstance();

    public static int mouseX;

    public static int mouseY;

    public static final int BIGGEST_GRID = 32;

    public GameWindow() {
	initialize();
	setTitle("Game Window");
	setSize(1000, 800);

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
    protected void initialize() {

	// Adds key listener to GameWindow object
	addKeyListener(new KeyBoardLogic());

	// Adds mouse listener to GameWindow object
	addMouseListener(new MouseLogic());

	visibleObjects = new ArrayList<GameObject>();

	hero = new AbstractPlayer(0, 0, 100);
	inventory = new Inventory();

	for (int i = 0; i <= 20; i++) {
	    if (i != 2)
		visibleObjects.add(new Block(i, 7, true));
	    if (i != 5)
		visibleObjects.add(new Block(5, i, true));
	}

	visibleObjects.add(new SmartEnemy(10, 10, 100));
	

	// Test purposes
	for (int i = 0; i <= 50; i++) {
	    Random ran = new Random();
	    int x = ran.nextInt(nodeMap.getWidth());
	    int y = ran.nextInt(nodeMap.getHeight());
	    if (nodeMap.getNode(x, y).isFree())
		visibleObjects.add(new SmartEnemy(x, y, 100));
	}

    }

    public final static void createInstance(GameObject obj) {
	visibleObjects.add(obj);
    }

    public final static void destroyInstance(GameObject obj) {
	visibleObjects.remove(obj);
    }

    public final static void destroyInstanceAtPosition(GameObject obj) {
	nodeMap.getNode(obj.getX(), obj.getY()).removeObj(obj);
	if (nodeMap.getNode(obj.getX(), obj.getY()).getObj().isEmpty())
	    nodeMap.getNode(obj.getX(), obj.getY()).setFree(true);

	nodeMap.getNode(obj.getX(), obj.getY()).setCost(1);
	destroyInstance(obj);
    }

    public final static void createEffect(Effect effect) {
	EffectsManager.getInstance().addEffect(effect);
    }

}
