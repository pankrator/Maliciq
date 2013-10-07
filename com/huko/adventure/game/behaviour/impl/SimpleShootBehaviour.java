package com.huko.adventure.game.behaviour.impl;

import com.huko.adventure.game.behaviour.ShooterStrategy;
import com.huko.adventure.game.entities.Bullet;
import com.huko.adventure.game.entities.LivingEntity;
import com.huko.adventure.window.GameWindow;

public class SimpleShootBehaviour implements ShooterStrategy {

	private LivingEntity performOn;

	private long lastShootTime;

	private int shootSpeed = 500;

	public SimpleShootBehaviour(LivingEntity performOn) {
		this.performOn = performOn;
//		this.lastShootTime = System.nanoTime();
	}

	@Override
	public void shoot() {
		if (performOn.distanceToObject(GameWindow.hero) < 5) {
			byte dir = performOn.pointDirection(GameWindow.hero);
			if (dir == -1)
				return;
			if ((System.nanoTime() - lastShootTime) / 1000000 > shootSpeed) {
				GameWindow.createInstance(new Bullet(performOn.getX() * 32 + 8,
						performOn.getY() * 32 + 8, dir, 1000, performOn));
				this.lastShootTime = System.nanoTime();
			}
		}
	}

}
