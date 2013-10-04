package com.huko.adventure.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import com.huko.adventure.game.behaviour.MoveStrategy;
import com.huko.adventure.game.behaviour.WandererStrategy;
import com.huko.adventure.window.GameWindow;

public abstract class Enemy extends LivingEntity implements Drawable, Updateable {

    protected enum States {
	WANDERING, ATTACKING, ESCAPING, STAYING, COMING
    }

    private States state;

    private int minDistanceToAwake;

    private MoveStrategy moveBehaviour;

    private WandererStrategy wanderBehaviour;

    public Enemy(int x, int y, int health) {
	super(x, y, health);
	this.state = States.STAYING;
	this.minDistanceToAwake = 10;
    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(Color.RED);
	g.drawRect(x * 32, y * 32, 32, 32);
    }

    @Override
    public void update() {

	if (state == States.STAYING) {
	    if (distanceToObject(GameWindow.hero) < minDistanceToAwake
		    && distanceToObject(GameWindow.hero) > 1)
		setState(States.COMING);
	    return;
	}

	if (state == States.COMING) {
	    if (distanceToObject(GameWindow.hero) > minDistanceToAwake + 5) {
		setState(States.STAYING);
		return;
	    }

	    if (distanceToObject(GameWindow.hero) <= 1) {
		setState(States.STAYING);
	    }

	    if (moveBehaviour != null)
		move();

	}

	if (state == States.WANDERING) {
	    if (wanderBehaviour != null)
		wander();
	}
    }

    public States getState() {
	return state;
    }

    public void setState(States state) {
	this.state = state;
    }

    public WandererStrategy getWanderBehaviour() {
	return wanderBehaviour;
    }

    public void setWanderBehaviour(WandererStrategy wanderBehaviour) {
	this.wanderBehaviour = wanderBehaviour;
    }

    public MoveStrategy getMoveBehaviour() {
	return moveBehaviour;
    }

    public void setMoveBehaviour(MoveStrategy moveBehaviour) {
	this.moveBehaviour = moveBehaviour;
    }

    public int getMinDistanceToAwake() {
	return minDistanceToAwake;
    }

    public void setMinDistanceToAwake(int minDistanceToAwake) {
	this.minDistanceToAwake = minDistanceToAwake;
    }

    public abstract void move();

    public abstract void wander();

}
