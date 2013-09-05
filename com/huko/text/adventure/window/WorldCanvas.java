package com.huko.text.adventure.window;

import java.awt.Graphics2D;

import com.huko.text.adventure.game.Drawable;
import com.huko.text.adventure.game.GameObject;
import com.huko.text.adventure.game.Updateable;

public class WorldCanvas extends Canvas implements Runnable {

	public WorldCanvas() {
		super();
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		while (true) {
			if (graphics != null) {
				clear();
				for (GameObject go : GameWindow.visibleObjects) {
					((Drawable) go).draw(graphics);
					((Updateable) go).update();
				}
				draw(graphics);
			}
			repaint();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException ie) {
			}
		}
	}

	private void draw(Graphics2D g) {
		GameWindow.hero.draw(g);
	}
}
