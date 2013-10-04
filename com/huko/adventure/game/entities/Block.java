package com.huko.adventure.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Obstacle implements Drawable {

    public Block(int x, int y, boolean isStatic) {
	super(x, y, isStatic);
    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(Color.BLUE);
	g.fillRect(getX() * 32, getY() * 32, 32, 32);
    }

}
