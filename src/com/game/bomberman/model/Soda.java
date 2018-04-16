package com.game.bomberman.model;

public class Soda extends Loot {

	public Soda(String name, int quatity) {// use for bag
		super(name, quatity);
	}

	public Soda(String name, Position position) {// use to display in map
		super(name, position);
	}

}
