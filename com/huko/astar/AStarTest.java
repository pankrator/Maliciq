package com.huko.astar;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TimeZone;

public class AStarTest extends Applet implements Cloneable {

	public static NodeMap map = new NodeMap(50, 50, 1);

//	public int startX = 0;
//	public int startY = 0;
//
//	public int endX = 25;
//	public int endY = 13;
	
	public Random rand = new Random();

	@Override
	public void init() {

		setSize(500, 500);

		for (int i = 3; i <= 20; i++) {
			if (i != 5)
				map.getNode(i, i - 3).setCost(0);
		}

	}

	@Override
	public void start() {
		long startTime = System.nanoTime();
		for (int i = 1; i <= 5000; i++) {
			NodeMap testMap = new NodeMap(50, 50, 1);
			int startX = rand.nextInt(40);
			int startY = rand.nextInt(40);
			int endX = rand.nextInt(40);
			int endY = rand.nextInt(40);
			aStartFind(testMap, testMap.getNode(startX, startY),
					testMap.getNode(endX, endY));
//			showRoad(testMap);
		}
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = elapsedTime / 1000000;
		System.out.println(seconds);
	}
	
//	private void showRoad(NodeMap map, int startX, int startY, int endX, int endY) {
//		Node curr = map.getNode(endX, endY);
//		Node end = map.getNode(startX, startY);
//		
//		g.setColor(Color.GREEN);
//		g.fillRect(startX * 16, startY * 16, 16, 16);
//
//		g.setColor(Color.RED);
//		g.fillRect(curr.getX() * 16, curr.getY() * 16, 16, 16);
//	}

	@Override
	public void paint(Graphics g) {
//		Node curr = map.getNode(endX, endY);
//		Node end = map.getNode(startX, startY);
//
//		g.setColor(Color.GREEN);
//		g.fillRect(startX * 16, startY * 16, 16, 16);
//
//		g.setColor(Color.RED);
//		g.fillRect(curr.getX() * 16, curr.getY() * 16, 16, 16);
//
//		curr = curr.getParent();
//
//		g.setColor(Color.CYAN);
//		for (int i = 3; i <= 20; i++) {
//			if (i != 5)
//				g.fillRect(i * 16, (i - 3) * 16, 16, 16);
//		}
//
//		g.setColor(Color.BLUE);
//		while (true) {
//			if (curr.getParent() != end) {
//				g.fillRect(curr.getX() * 16, curr.getY() * 16, 16, 16);
//				curr = curr.getParent();
//			} else {
//				g.fillRect(curr.getX() * 16, curr.getY() * 16, 16, 16);
//				break;
//			}
//		}
	}
	
	private boolean aStartFind(NodeMap map, Node start, Node end) {
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
							if (((Node) next).getCost() > 0
									&& !((Node) next).isOnClosedList()) {
								if (!((Node) next).isOnOpenList()) {
									((Node) next).setParent(current);
									((Node) next).setG(current.getG()
											+ ((Node) next).getCost());
									((Node) next).setH(((Node) next)
											.calcHeuristic(end));
									openList.add((Node) next);
									((Node) next).setOnOpenList(true);
								} else {
									if (current.getG() > ((Node) next).getG()
											+ current.getCost()) {
										current.setParent((Node) next);
										current.setG(((Node) next).getG()
												+ current.getCost());
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
