package com.huko.text.adventure.game.inventory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.huko.text.adventure.game.RelativeDrawable;

public class Bag implements RelativeDrawable {

	private static final int SLOT_WIDTH = 20;

	private static final int SLOT_HEIGHT = 20;
	
	private int numOfSlots;
	
	private ArrayList<Item> items;
	
	public Bag() {
		items = new ArrayList<Item>();
		numOfSlots = 6;
	}
	
	public Bag(int numOfSlots) {
		items = new ArrayList<Item>();
		this.numOfSlots = numOfSlots;
	}

	public int getNumOfSlots() {
		return numOfSlots;
	}

	public void setNumOfSlots(int numOfSlots) {
		this.numOfSlots = numOfSlots;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	@Override
	public void relativeDraw(Graphics2D g, int relativeX, int relativeY) {
		g.setColor(Color.CYAN);
		g.drawRect(relativeX, relativeY, SLOT_WIDTH * numOfSlots, SLOT_HEIGHT);
//		for(Item item : items) {
//			item.relativeDraw(g, relativeX, relativeY);
//		}
	}
	
	
	
}
