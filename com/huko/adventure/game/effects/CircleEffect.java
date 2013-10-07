package com.huko.adventure.game.effects;

import java.awt.Color;
import java.awt.Graphics2D;

public class CircleEffect extends Effect {

	private Color color;

	private int circleRadius;

	public CircleEffect(int x, int y, Color c, int lifetime) {
		super(x, y, lifetime);
		this.color = c;
		circleRadius = 5;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillArc(getX() * 32, getY() * 32, circleRadius, circleRadius, 0, 360);
		this.circleRadius += 5;
	}

}
