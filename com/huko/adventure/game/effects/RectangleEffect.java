package com.huko.adventure.game.effects;

import java.awt.Graphics2D;

public class RectangleEffect extends Effect {

    
    
    public RectangleEffect(int x, int y, int lifetime) {
	super(x, y, lifetime);
    }

    @Override
    public void draw(Graphics2D g) {
	g.drawRect(getX() * 32, getY() * 32, 7, 7);
	g.drawArc(getX() * 32, getY() * 32, 20, 20, 0, 90);
    }

}
