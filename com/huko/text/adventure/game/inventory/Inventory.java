package com.huko.text.adventure.game.inventory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.huko.text.adventure.game.Drawable;

public class Inventory implements Drawable {

	private static final int BAG_HEIGHT = 30;
	
	private static final int BAG_MAX_WIDTH = 200;

	private int numOfBags;

	private ArrayList<Bag> bags;

	public Inventory() {
		this.numOfBags = 1;
		this.bags = new ArrayList<Bag>();
		bags.add(new Bag());
	}

	public Inventory(int numOfBags) {
		this.numOfBags = numOfBags;
		this.bags = new ArrayList<Bag>();
		for(int i = 1; i<=numOfBags;i++) {
			bags.add(new Bag());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.drawRect(0, 0, BAG_MAX_WIDTH, BAG_HEIGHT * numOfBags);
		g.setColor(Color.GRAY); 
		int yOffSet = 10;
		for(Bag bag : bags) {
			bag.relativeDraw(g, 10, yOffSet);
//			for(Item item : bag.getItems()) {
//				g.drawImage(item.getImage(), xOffSet, yOffSet, null);
//				xOffSet += SLOT_WIDTH;
//			}
			yOffSet += BAG_HEIGHT;
		}
	}

}
