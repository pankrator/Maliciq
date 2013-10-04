package com.huko.adventure.game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.huko.adventure.window.GameWindow;

public class KeyBoardLogic implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {

	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    GameWindow.hero.moveInGrid(-1, 0);
	}

	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    GameWindow.hero.moveInGrid(1, 0);
	}

	if (e.getKeyCode() == KeyEvent.VK_UP) {
	    GameWindow.hero.moveInGrid(0, -1);
	}

	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    GameWindow.hero.moveInGrid(0, 1);
	}

	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    GameWindow.hero.fire();
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
