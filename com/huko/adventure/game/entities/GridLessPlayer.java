package com.huko.adventure.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import com.huko.adventure.window.GameWindow;

public class GridLessPlayer extends AbstractPlayer implements Drawable {

    private int nonGridX;

    private int nonGridY;

    public GridLessPlayer(int x, int y, int health) {
	super(x, y, health, false);
	this.nonGridX = x * 32;
	this.nonGridY = y * 32;
	GameWindow.nodeMap.getNode(x, y).setFree(false);
	GameWindow.nodeMap.getNode(x, y).addObj(this);

    }

//    @Override
//    public void moveInGrid(int amountX, int amountY) {
//	super.moveInGrid(amountX, amountY);
//	nonGridX += amountX * 2;
//	nonGridY += amountY * 2;
//    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(Color.BLUE);
	g.setColor(Color.GREEN);
	g.drawOval(nonGridX, nonGridY, 32, 32);
    }

}
