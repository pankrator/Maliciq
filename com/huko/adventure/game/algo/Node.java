package com.huko.adventure.game.algo;

import java.util.ArrayList;
import java.util.List;

import com.huko.adventure.game.entities.GameObject;

public final class Node implements Comparable<Node>{

	private int x;

	private int y;

	private double cost;

	private double g;

	private double h;
	
	private boolean isFree;

	private boolean onClosedList;

	private boolean onOpenList;
	
	private List<GameObject> obj;

	private Node parent;

	private NodeMap mapParent;

	public Node(int x, int y, double cost, NodeMap mapParent) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.mapParent = mapParent;
		this.obj = new ArrayList<GameObject>(4);

		isFree = true;
		onClosedList = false;
		onOpenList = false;
	}

	public Object[] getSurroundingNodes() {
		return mapParent.getSurroundingNodes(x, y);
	}

	public double calcHeuristic(Node target) {
		return calcHeuristic(target.x, target.y);
	}

	public double calcHeuristic(int x, int y) {
		double h = mapParent.calcHeuristic(this.x, this.y, x, y);
		if (h != -1) {
			return h * cost;
		}
		return -1;
	}

	public double getF() {
		return this.g + this.h;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	
	public boolean isFree() {
		return (isFree);
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean isOnClosedList() {
		return onClosedList;
	}

	public void setOnClosedList(boolean onClosedList) {
		this.onClosedList = onClosedList;
	}

	public boolean isOnOpenList() {
		return onOpenList;
	}

	public void setOnOpenList(boolean onOpenList) {
		this.onOpenList = onOpenList;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public NodeMap getMapParent() {
		return mapParent;
	}

	public void setMapParent(NodeMap mapParent) {
		this.mapParent = mapParent;
	}
	

	public List<GameObject> getObj() {
		return obj;
	}
	
	public GameObject getActualObj(GameObject obj) {
	    return this.obj.get(this.obj.indexOf(obj));
	}
	
	public GameObject getRandomObj() {
	    return this.obj.get(0);
	}
	
	public void addObj(GameObject obj) {
	    this.obj.add(obj);
	}
	
	public void removeObj(GameObject obj) {
	    this.obj.remove(obj);
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(getF(), o.getF());
	}

}
