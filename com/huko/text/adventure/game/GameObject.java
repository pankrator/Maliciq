package com.huko.text.adventure.game;

import com.huko.text.adventure.window.GameWindow;

public abstract class GameObject {

	protected int startX;
	
	protected int startY;
	
	protected int x;
	
	protected int y;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		GameWindow.map[x][y].setFree(false);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public void move(int amountX, int amountY) {
		
		if (!isLegalMove(x + amountX, y + amountY))
			return;
		
		if(!placeFree(x + amountX, y + amountY))
			return;
		
		GameWindow.map[x][y].setFree(true);
		
		x += amountX;
		y += amountY;

		GameWindow.map[x][y].setFree(false);
	}

	public boolean isLegalMove(int x, int y) {
		if (x < 0 || x > 60 || y < 0 || y > 60)
			return false;

		return true;
	}
	
	public boolean placeFree(int x, int y) {
		if(GameWindow.map[x][y].isFree())
			return true;
		
		return false;
		
	}
	

}
