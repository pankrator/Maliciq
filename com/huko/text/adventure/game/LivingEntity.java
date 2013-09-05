package com.huko.text.adventure.game;


public abstract class LivingEntity extends GameObject {

	protected int  health;
	
	public LivingEntity(int x, int y, int health) {
		super(x, y);
		this.health = health;
	}

	
	public int getHealth() {
		return health;
	}
}
