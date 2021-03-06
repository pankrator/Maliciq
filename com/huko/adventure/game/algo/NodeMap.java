package com.huko.adventure.game.algo;

import java.util.ArrayList;
import java.util.List;

public final class NodeMap {

    private int width;

    private int height;

    private int id;

    private String name;

    private Node[][] nodes;

    private boolean changed;

    public NodeMap(int width, int height, Node[][] nodes) {
	this.width = width;
	this.height = height;

	this.nodes = new Node[width][height];
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		this.nodes[x][y] = new Node(x, y, nodes[x][y].getCost(), this);
	    }
	}
    }

    public NodeMap(int width, int height, double initialCost) {
	this.width = width;
	this.height = height;

	nodes = new Node[width][height];
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		nodes[x][y] = new Node(x, y, initialCost, this);
	    }
	}
    }

    public boolean isChanged() {
	return changed;
    }

    public void setChanged(boolean change) {
	this.changed = change;
    }

    public Node getNode(int x, int y) {
	return nodes[x][y];
    }

    public void setNode(int x, int y, Node node) {
	nodes[x][y] = node;
    }

    public Object[] getSurroundingNodes(int x, int y) {
	List<Node> tmpNodes = new ArrayList<Node>(8);

	if (x - 1 >= 0) {
	    tmpNodes.add(nodes[x - 1][y]);
	}

	if (x + 1 < width) {
	    tmpNodes.add(nodes[x + 1][y]);
	}

	if (y - 1 >= 0) {
	    tmpNodes.add(nodes[x][y - 1]);
	}

	if (y + 1 < height) {
	    tmpNodes.add(nodes[x][y + 1]);
	}

	return tmpNodes.toArray();
    }

    public double calcHeuristic(int startX, int startY, int endX, int endY) {

	double h = -1;

	h = Math.abs(startX - endX) + Math.abs(startY - endY);

	return (double) h;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Node[][] getNodes() {
	return nodes;
    }
    
    public void setNodes(Node[][] nodes) {
	this.nodes = nodes;
    }
    
    public void setCosts(Node[][] nodes) {
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		this.nodes[x][y].setG(0.0);
		this.nodes[x][y].setH(0.0);
		this.nodes[x][y].setCost(nodes[x][y].getCost());
	    }
	}
    }
    
    @Override
    public String toString() {
	return String.valueOf(this.nodes[0][7].getCost());
    }

}
