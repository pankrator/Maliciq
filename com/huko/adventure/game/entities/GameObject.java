package com.huko.adventure.game.entities;

import com.huko.adventure.window.GameWindow;

public abstract class GameObject {

    protected int startX;

    protected int startY;

    protected int x;

    protected int y;
    

    @SuppressWarnings("unused")
    private boolean alignToGrid;

    public GameObject(int x, int y) {
	this.x = x;
	this.y = y;
	this.startX = x;
	this.startY = y;
	GameWindow.nodeMap.getNode(x, y).setFree(false);
	GameWindow.nodeMap.getNode(x, y).addObj(this);
    }

    /**
     * Used to create Objects that are not moving on the grid
     * 
     * @param x
     * @param y
     * @param toGrid
     */
    public GameObject(int x, int y, boolean toGrid) {
	this.x = x;
	this.y = y;
	this.startX = x;
	this.startY = y;
	alignToGrid = toGrid;
    }

    public int distanceToObject(GameObject target) {
	return Math.abs(getX() - target.getX()) + Math.abs(getY() - target.getY());
    }
    
    public int distanceToPoint(int pointX, int pointY) {
	return Math.abs(getX() - pointX) + Math.abs(getY() - pointY);
    }

    public void setX(int x) {
	this.x = x;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public int getStartX() {
	return startX;
    }

    public int getStartY() {
	return startY;
    }

    public int getXtoGrid() {
	return x / 32;
    }

    public int getYtoGrid() {
	return y / 32;
    }
    
    

}
