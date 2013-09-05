package com.huko.text.adventure.window;

public class StatCanvas extends Canvas {

	public StatCanvas() {
		super();
//		Thread th = new Thread(this);
//		th.start();
	}

//	@Override
//	public void run() {
//		if (graphics != null) {
//			clear();
//			draw();
//		}
//		repaint();
//	}

	public void draw() {
		if (graphics != null) {
			clear();
			GameWindow.inventory.draw(graphics);
		}
		repaint();
	}

}
