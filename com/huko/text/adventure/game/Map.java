package com.huko.text.adventure.game;

import java.awt.Image;

public class Map {

	private GameObject object;

	private boolean isTile;

	private Image tile;

	private boolean isPartOfBiggerObject;

	private GameObject biggerObject;

	private boolean isFree;

	public Map() {
		this.isFree = true;
	}

	public GameObject getObject() {
		return object;
	}

	public void setObject(GameObject obj) {
		this.object = obj;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean isBigger() {
		return isPartOfBiggerObject;
	}

	public GameObject getBiggerObject() {
		return biggerObject;
	}

	public boolean isTile() {
		return isTile;
	}

	public void setTile(Image tile) {
		this.tile = tile;
		if (tile != null)
			isTile = true;
		else
			isTile = false;
	}

}
