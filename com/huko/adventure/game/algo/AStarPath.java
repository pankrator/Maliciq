package com.huko.adventure.game.algo;

import java.util.PriorityQueue;

public final class AStarPath {

    public static boolean aStarFindByCoords(NodeMap map2, int startX2, int startY2, int endX2,
	    int endY2) {

	return aStarFind(map2, map2.getNode(startX2, startY2), map2.getNode(endX2, endY2));
    }

    public static boolean aStarFind(NodeMap map, Node start, Node end) {
	if (start != null && end != null) {
	    if (start.getMapParent() == map && end.getMapParent() == map) {
		boolean pathFound = true;
		PriorityQueue<Node> openList = new PriorityQueue<Node>();
		PriorityQueue<Node> closedList = new PriorityQueue<Node>();
		openList.add(start);
		start.setOnOpenList(true);
		while (!end.isOnClosedList()) {
		    if (openList.size() > 0) {
			Node current = openList.remove();
			closedList.add(current);
			current.setOnClosedList(true);
			Object[] surrounding = current.getSurroundingNodes();
			for (Object next : surrounding) {
			    if (((Node) next).getCost() > 0 && !((Node) next).isOnClosedList()) {
				if (!((Node) next).isOnOpenList()) {
				    ((Node) next).setParent(current);
				    ((Node) next).setG(current.getG() + ((Node) next).getCost());
				    ((Node) next).setH(((Node) next).calcHeuristic(end));
				    openList.add((Node) next);
				    ((Node) next).setOnOpenList(true);
				} else {
				    if (current.getG() > ((Node) next).getG() + current.getCost()
					    && ((Node) next).isFree()) {
					current.setParent((Node) next);
					current.setG(((Node) next).getG() + current.getCost());
					openList.remove(current);
					openList.add(current);
				    }
				}
			    }
			}
		    } else {
			pathFound = false;
			break;
		    }
		}
		return pathFound;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }

}
