package com.game.bomberman.model;

public class Shoes extends Loot {

	public Shoes(String name, Position positon) {// use for display itemShoe in
												// map
		super(name, positon);
	}

	public Shoes(String name, int quatity) {// use for bag
		super(name, quatity);
	}
}
