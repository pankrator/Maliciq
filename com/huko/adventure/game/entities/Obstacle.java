package com.huko.adventure.game.entities;

import com.huko.adventure.window.GameWindow;

public abstract class Obstacle extends GameObject {

    protected boolean isStatic;

    public Obstacle(int x, int y, boolean isStatic) {
	super(x, y);
	this.isStatic = isStatic;
	GameWindow.nodeMap.getNode(x, y).setCost(0);
    }

    public boolean isStatic() {
	return isStatic;
    }

    public void setStatic(boolean isStatic) {
	this.isStatic = isStatic;
    }

}
