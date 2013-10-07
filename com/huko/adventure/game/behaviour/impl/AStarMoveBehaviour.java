package com.huko.adventure.game.behaviour.impl;

import java.util.Random;
import java.util.Stack;

import com.huko.adventure.game.algo.AStarPath;
import com.huko.adventure.game.algo.Node;
import com.huko.adventure.game.algo.NodeMap;
import com.huko.adventure.game.behaviour.MoveStrategy;
import com.huko.adventure.game.entities.LivingEntity;
import com.huko.adventure.window.GameWindow;

/**
 * A* Pathfinding implementation
 * @author pankrator
 *
 */
public class AStarMoveBehaviour implements MoveStrategy {
    
    private Stack<Node> path;
    
    private long movementTimer;
    
    private LivingEntity performOn;
    
    private Random rd;

    public AStarMoveBehaviour(LivingEntity performOn) {
	movementTimer = System.nanoTime();
	rd = new Random();
	path = new Stack<Node>();
	this.performOn = performOn;
    }
    

    @Override
    public void moveTowards(int targetx, int targety) {
	
	if(performOn.distanceToPoint(targetx, targety) <= 1) {
	    return;
	}
	
	NodeMap map = new NodeMap(GameWindow.nodeMap.getWidth(), GameWindow.nodeMap.getHeight(),
		GameWindow.nodeMap.getNodes());
	
	
	if (!AStarPath.aStarFindByCoords(map, performOn.getX(), performOn.getY(), targetx, targety)) {
	    return;
	}

	path.clear();

	Node curr = map.getNode(targetx, targety);
	Node end = map.getNode(performOn.getX(), performOn.getY());

	while (true) {
	    if (curr.getParent() != end && curr.getParent() != null) {
		path.add(curr);
		curr = curr.getParent();
	    } else {
		path.add(curr);
		break;
	    }
	}

	if (path.empty())
	    return;
	

	if ((System.nanoTime() - movementTimer) / 1000000 > rd.nextInt(400) + 500) {
	    Node place = path.pop();
	    
	    performOn.moveToGrid(place.getX(), place.getY());
	    movementTimer = System.nanoTime();
	}

    }
}
