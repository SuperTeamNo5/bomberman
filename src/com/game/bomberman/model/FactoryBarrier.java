package com.game.bomberman.model;

public class FactoryBarrier extends CreateCentre {
	private Barrier bar;

	public FactoryBarrier() {
	}

	// apply factory pattern
	@Override
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
