package com.huko.text.adventure.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * Draw and Update logic is here
 * 
 * @author NIST
 * 
 */
public abstract class Canvas extends JComponent {

	protected Image image;

	protected Graphics2D graphics;

	public Canvas() {
		setDoubleBuffered(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			graphics = (Graphics2D) image.getGraphics();
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			clear();
		}
		g.drawImage(image, 0, 0, null);
	}

	public void clear() {
		graphics.setPaint(Color.white);
		graphics.fillRect(0, 0, getSize().width, getSize().height);
//		 repaint();
	}

}
