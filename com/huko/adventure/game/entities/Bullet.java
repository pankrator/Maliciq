package com.huko.adventure.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.huko.adventure.game.effects.CircleEffect;
import com.huko.adventure.window.GameWindow;

/**
 * This class doesn't present on the node grid !!
 * 
 * @author nist
 * 
 */
public class Bullet extends GameObject implements Drawable, Updateable {

    private byte direction;

    private long creationTime;

    private byte speed;

    private int lifetime;

    private GameObject shooter;

    private ArrayList<Class<? extends GameObject>> canImpactList = new ArrayList<Class<? extends GameObject>>();

    private ArrayList<GameObject> forbiddenList = new ArrayList<GameObject>();

    public Bullet(int x, int y, byte dir, int lifetime, GameObject shooter) {
	super(x, y, false);
	this.lifetime = lifetime;
	addToImpact(SmartEnemy.class);
	addToImpact(GameWindow.hero);
	addToForbidden(shooter);
	this.shooter = shooter;
	speed = 5;
	direction = dir;
	creationTime = System.nanoTime();
    }

    @Override
    public void update() {

	if ((System.nanoTime() - creationTime) / 1000000 > lifetime)
	    GameWindow.destroyInstance(this);

	/*
	 * Check if bullet destroy something
	 */
	moving();

	switch (direction) {
	case 2:
	    y += speed;
	    break;
	case 4:
	    x -= speed;
	    break;
	case 6:
	    x += speed;
	    break;
	case 8:
	    y -= speed;
	    break;
	}
    }

    protected void moving() {

	int gridX = getXtoGrid();
	int gridY = getYtoGrid();

	if (gridX < 0 || gridY < 0)
	    return;

	if (!GameWindow.nodeMap.getNode(gridX, gridY).isFree()) {

	    if (canImpact(GameWindow.nodeMap.getNode(gridX, gridY).getRandomObj())) {

		GameWindow.destroyInstanceAtPosition(GameWindow.nodeMap.getNode(gridX, gridY)
			.getRandomObj());
	    }

	    if (!GameWindow.nodeMap.getNode(gridX, gridY).getObj().contains(shooter)) {
		GameWindow.createEffect(new CircleEffect(gridX, gridY, Color.GREEN, 200));
		GameWindow.destroyInstance(this);
	    }
	}
    }

    @Override
    public void draw(Graphics2D g) {
	g.setColor(Color.yellow);
	g.fillRect(x, y, 16, 16);
    }

    public boolean canImpact(GameObject go) {
	return (canImpactList.contains(go.getClass()) && !forbiddenList.contains(go));
    }

    public void addToImpact(GameObject go) {
	canImpactList.add(go.getClass());
    }

    public void addToForbidden(GameObject go) {
	forbiddenList.add(go);
    }

    public void removeFromForbidden(GameObject go) {
	forbiddenList.remove(go);
    }

    public void addToImpact(Class<? extends GameObject> go) {
	canImpactList.add(go);
    }

    public void removeFromImpact(GameObject go) {
	canImpactList.remove(go.getClass());
    }

    public void removeFromImpact(Class<? extends GameObject> go) {
	canImpactList.remove(go);
    }

}
