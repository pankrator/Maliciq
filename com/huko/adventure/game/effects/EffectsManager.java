package com.huko.adventure.game.effects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class EffectsManager {

    private static EffectsManager INSTANCE;

    private List<Effect> effectsList;

    private EffectsManager() {
	effectsList = new ArrayList<Effect>();
    }

    public static EffectsManager getInstance() {
	if (INSTANCE == null)
	    INSTANCE = new EffectsManager();
	return INSTANCE;
    }

    public void performEffects(Graphics2D g) {
	for (Effect effect : effectsList) {
	    if (effect != null) {
		if ((System.nanoTime() - effect.getCreationTime()) / 1000000 > effect.getLifetime()) {
		    destroyEffect(effect);
		    return;
		}
		effect.draw(g);
	    }
	}
    }

    public void destroyEffect(Effect effect) {
	effectsList.remove(effect);
    }

    public void addEffect(Effect effect) {
	effectsList.add(effect);
    }

}
