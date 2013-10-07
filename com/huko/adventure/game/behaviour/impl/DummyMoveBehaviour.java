package com.huko.adventure.game.behaviour.impl;

import java.util.Random;

import com.huko.adventure.game.behaviour.MoveStrategy;
import com.huko.adventure.game.entities.LivingEntity;
import com.huko.adventure.window.GameWindow;

/**
 * Dummy move algorithm implementation
 * 
 * @author pankrator
 * 
 */
public class DummyMoveBehaviour implements MoveStrategy {

    private LivingEntity performOn;

    private Random rd;

    public DummyMoveBehaviour(LivingEntity performOn) {
	this.performOn = performOn;
	rd = new Random();
    }

    @Override
    public void moveTowards(int targetx, int targety) {

	if (performOn.distanceToPoint(targetx, targety) <= 1) {
	    return;
	}

	if (rd.nextInt(50) != 1) {
	    return;
	}

	if (performOn.distanceToPoint(targetx, targety) < 2) {
	    if (performOn.placeFree(targetx, targety)) {
		
		performOn.moveToGrid(targetx, targety);
	    }
	    return;
	}

	byte hStep[] = { 0, 0, 0, 0 };
	byte vStep[] = { 0, 0, 0, 0 };

	int i = 0;

	if (targetx < performOn.getX()) {
	    hStep[i] = -1;
	    vStep[i] = 0;
	    i++;
	}
	if (targetx > performOn.getX()) {
	    hStep[i] = 1;
	    vStep[i] = 0;
	    i++;
	}
	if (targety < performOn.getY()) {
	    hStep[i] = 0;
	    vStep[i] = -1;
	    i++;
	}
	if (targety > performOn.getY()) {
	    hStep[i] = 0;
	    vStep[i] = 1;
	    i++;
	}

	for (int j = 0; j < i; j++) {
	    if (performOn.placeFree(performOn.getX() + hStep[j], performOn.getY() + vStep[j])) {
		performOn.moveInGrid(hStep[j], vStep[j]);
	    }
	}
    }

}
