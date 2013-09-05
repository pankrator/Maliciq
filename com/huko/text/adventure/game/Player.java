package com.huko.text.adventure.game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.huko.text.adventure.game.inventory.Inventory;

public class Player extends LivingEntity implements Drawable, Updateable {
	
	public Player(int x, int y, int health) {
		super(x, y, health);
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawRect(getX()*32, getY()*32, 32, 32);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
