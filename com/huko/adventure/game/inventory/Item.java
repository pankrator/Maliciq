package com.huko.adventure.game.inventory;

import java.awt.Graphics2D;
import java.awt.Image;

import com.huko.adventure.game.entities.RelativeDrawable;

public class Item implements RelativeDrawable {
	
	private Image image;
	
	public Item() {
		
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public void relativeDraw(Graphics2D g, int relativeX, int relativeY) {
		
	}
	
	
}
