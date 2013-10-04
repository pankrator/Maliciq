package com.huko.adventure.game.entities;

import com.huko.adventure.window.GameWindow;

public abstract class LivingEntity extends GameObject {

    protected int health;

    public LivingEntity(int x, int y, int health) {
	super(x, y);
	this.health = health;
    }

    public LivingEntity(int x, int y, int health, boolean toGrid) {
	super(x, y, toGrid);
	this.health = health;
    }

    public int getHealth() {
	return health;
    }

    public void moveInGrid(int amountX, int amountY) {

	if (!isLegalMove(x + amountX, y + amountY))
	    return;

	if (!placeFree(x + amountX, y + amountY))
	    return;

	GameWindow.nodeMap.getNode(x, y).setFree(true);
	GameWindow.nodeMap.getNode(x, y).removeObj(this);
	GameWindow.nodeMap.getNode(x, y).setCost(1);

	x += amountX;
	y += amountY;

	GameWindow.nodeMap.getNode(x, y).setFree(false);
	GameWindow.nodeMap.getNode(x, y).addObj(this);
	GameWindow.nodeMap.getNode(x, y).setCost(0);
    }

    public void moveToGrid(int gridX, int gridY) {

	if (!isLegalMove(gridX, gridY))
	    return;

	if (!placeFree(gridX, gridY))
	    return;

	GameWindow.nodeMap.getNode(x, y).setFree(true);
	GameWindow.nodeMap.getNode(x, y).removeObj(this);
	GameWindow.nodeMap.getNode(x, y).setCost(1);

	setX(gridX);
	setY(gridY);

	GameWindow.nodeMap.getNode(x, y).setFree(false);
	GameWindow.nodeMap.getNode(x, y).addObj(this);
	GameWindow.nodeMap.getNode(x, y).setCost(0);

    }

    /**
     * 
     * @param pointX x coordinates to look for
     * @param pointY y coordinates to look for
     * @return the direction where (pointX,pointY) is 
     * or -1 if the direction cannot be determined
     */
    public final byte pointDirection(int pointX, int pointY) {

	if (pointX == getX()) {
	    if (pointY > getY())
		return (byte) 2;
	    if (pointY < getY())
		return (byte) 8;
	} else if (pointY == getY()) {
	    if (pointX > getX())
		return (byte) 6;
	    if (pointX < getX())
		return (byte) 4;
	}

	return (byte) -1;
    }

    public final boolean isLegalMove(int x, int y) {
	if (x < 0 || x > GameWindow.nodeMap.getWidth() || y < 0
		|| y > GameWindow.nodeMap.getHeight())
	    return false;

	return true;
    }

    public final boolean placeFree(int x, int y) {
	if (GameWindow.nodeMap.getNode(x, y).isFree())
	    return true;

	return false;
    }
}
