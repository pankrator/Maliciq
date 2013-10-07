package com.huko.adventure.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import com.huko.adventure.window.GameWindow;

public class AbstractPlayer extends LivingEntity implements Drawable {

    private long fireRate = 200;

    private long lastFire;

    private byte dir = 4;

    public AbstractPlayer(int x, int y, int health) {
	super(x, y, health);
    }

    public AbstractPlayer(int x, int y, int health, boolean toGrid) {
	super(x, y, health, toGrid);
    }

    @Override
    public final void moveInGrid(int amountX, int amountY) {

	if (x + amountX > x)
	    dir = 6;
	else if (x + amountX < x)
	    dir = 4;

	if (y + amountY > y)
	    dir = 2;
	else if (y + amountY < y)
	    dir = 8;

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
    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(Color.GREEN);
	g.drawOval(getX() * 32, getY() * 32, 32, 32);
    }

    public void fire() {
	if ((System.nanoTime() - lastFire) / 1000000 > fireRate) {
	    lastFire = System.nanoTime();
	    //TODO create a new method for firing a bullet
	    GameWindow.createInstance(new Bullet(getX() * 32 + 8, getY() * 32 + 8, this.dir, 1000,
		    this));
	}
    }

    public byte getDir() {
	return dir;
    }

    public void setDir(byte dir) {
	this.dir = dir;
    }

}
