package com.huko.adventure.game.entities;

import com.huko.adventure.game.behaviour.impl.DummyMoveBehaviour;
import com.huko.adventure.game.behaviour.impl.WandererBehaviour;
import com.huko.adventure.window.GameWindow;

public class DummyEnemy extends Enemy {

    public DummyEnemy(int x, int y, int health) {
	super(x, y, health);
	setMoveBehaviour(new DummyMoveBehaviour(this));
	setWanderBehaviour(new WandererBehaviour(this, 1));
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
