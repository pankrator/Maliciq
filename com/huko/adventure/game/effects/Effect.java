package com.huko.adventure.game.effects;

import com.huko.adventure.game.entities.Drawable;

public abstract class Effect implements Drawable {

    private long creationTime;

    private int lifetime;

    private int x;

    private int y;

    public Effect(int x, int y, int lifetime) {
	this.x = x;
	this.y = y;
	this.lifetime = lifetime;
	this.creationTime = System.nanoTime();
    }

    public long getCreationTime() {
	return creationTime;
    }

    public int getLifetime() {
	return lifetime;
    }

    public void setLifetime(int lifetime) {
	this.lifetime = lifetime;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

}
