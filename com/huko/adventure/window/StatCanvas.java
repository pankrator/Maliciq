package com.huko.adventure.window;

public class StatCanvas extends Canvas implements Runnable {

    public StatCanvas() {
	super();
	Thread th = new Thread(this);
	th.start();
    }

    @Override
    public void run() {
	if (graphics != null) {
	    clear();
	    draw();
	}
	repaint();
    }

    public void draw() {
	GameWindow.inventory.draw(graphics);
    }

}
