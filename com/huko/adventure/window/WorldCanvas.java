package com.huko.adventure.window;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.huko.adventure.game.entities.Drawable;
import com.huko.adventure.game.entities.GameObject;
import com.huko.adventure.game.entities.Updateable;

public class WorldCanvas extends Canvas implements Runnable {

	public WorldCanvas() {
		super();
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		while (true) {
			long start = System.nanoTime();
			if (graphics != null) {
				clear();
				List<GameObject> tempGo = new ArrayList<GameObject>(
						GameWindow.visibleObjects);
				for (GameObject go : tempGo) {
					if (go instanceof Drawable)
						((Drawable) go).draw(graphics);
					if (go instanceof Updateable)
						((Updateable) go).update();
				}
				GameWindow.explosionManager.performEffects(graphics);
//				draw(graphics);
			}
			repaint();
			// System.out.println((long) ((System.nanoTime() - start)) /
			// 1000000);
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException ie) {
			}
		}
	}

//	private void draw(Graphics2D g) {
//		if (GameWindow.nodeMap
//				.getNode(GameWindow.hero.getX(), GameWindow.hero.getY())
//				.getObj().contains(GameWindow.hero)) {
//			System.out.println("Tuka eeee");
//		}
//	}
}
