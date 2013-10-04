package com.huko.adventure.game.entities;

import com.huko.adventure.game.behaviour.impl.AStarMoveBehaviour;
import com.huko.adventure.game.behaviour.impl.WandererBehaviour;
import com.huko.adventure.window.GameWindow;

public class SmartEnemy extends Enemy {

    public SmartEnemy(int x, int y, int health) {
	super(x, y, health);
	setMoveBehaviour(new AStarMoveBehaviour(this));
	setWanderBehaviour(new WandererBehaviour(this, 5));
    }

    @Override
    public void move() {
	getMoveBehaviour().moveTowards(GameWindow.hero.getX(), GameWindow.hero.getY());
    }

    @Override
    public void wander() {
	getWanderBehaviour().moveWandering();
    }

}
