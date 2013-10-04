package com.huko.adventure.game.behaviour.impl;

import java.util.Random;

import com.huko.adventure.game.behaviour.WandererStrategy;
import com.huko.adventure.game.entities.LivingEntity;


public class WandererBehaviour implements WandererStrategy {

    private LivingEntity performOn;
    
    private Random rd;
    
    private int wanderingRadius;
    
    public WandererBehaviour(LivingEntity performOn, int wanderingRadius) {
	this.performOn = performOn;
	rd = new Random();
	this.wanderingRadius = wanderingRadius;
    }
    
    @Override
    public void moveWandering() {
	
	switch (rd.nextInt(100)) {
	case 6:
	    if (performOn.getX() + 1 <= performOn.getStartX() + this.wanderingRadius)
		performOn.moveInGrid(1, 0);
	    break;
	case 4:
	    if (performOn.getX() - 1 >= performOn.getStartX() - this.wanderingRadius)
		performOn.moveInGrid(-1, 0);
	    break;
	case 2:
	    if (performOn.getY() + 1 <= performOn.getStartY() + this.wanderingRadius)
		performOn.moveInGrid(0, 1);
	    break;
	case 8:
	    if (performOn.getY() - 1 >= performOn.getStartY() - this.wanderingRadius)
		performOn.moveInGrid(0, -1);
	    break;
	}
    }
    
}
