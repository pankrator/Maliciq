package com.huko.text.adventure.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends LivingEntity implements Drawable, Updateable {

	private enum States {
		WANDERING, ATTACKING, ESCAPING, STAYING
	}

	private States state;

	private int wanderingRadius;

	public Enemy(int x, int y, int health, int wanderingRadius) {
		super(x, y, health);
		this.wanderingRadius = wanderingRadius;
		this.state = States.WANDERING;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawRect(x * 32, y * 32, 32, 32);
	}

	@Override
	public void update() {
		if (state == States.STAYING)
			return;

		if (state == States.WANDERING) {
			Random rd = new Random();
			switch (rd.nextInt(100)) {
			case 6:
				if (x + 1 <= startX + wanderingRadius)
					move(1, 0);
				break;
			case 4:
				if (x - 1 >= startX - wanderingRadius)
					move(-1, 0);
				break;
			case 2:
				if (y + 1 <= startY + wanderingRadius)
					move(0, 1);
				break;
			case 8:
				if (y - 1 >= startY - wanderingRadius)
					move(0, -1);
				break;
			}
		}

	}

}
