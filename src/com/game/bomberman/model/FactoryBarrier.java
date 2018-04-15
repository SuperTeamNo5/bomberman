package com.game.bomberman.model;

public class FactoryBarrier {
	private Barrier bar;

	public FactoryBarrier() {
	}

	// apply factory pattern
	public Barrier createBarrier(String name, Position position) {
		switch (name) {
		case "wall":
			bar = new Wall("wall", position);
			break;
		case "barrel":
			bar = new Barrel("barrel", position);
			break;

		default:
			break;
		}
		return bar;

	}
}
